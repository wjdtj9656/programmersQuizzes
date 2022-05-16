import java.util.*;
class Node{
    int num;
    int depth;
    Node prev;
    int wn;
    public Node(int num, int depth, Node prev,int wn){
        this.num = num;
        this.depth = depth;
        this.prev = prev;
        this.wn = wn;
    }
    public int compareTo(Node o1){
        return this.depth - o1.depth;
    }
}
class Solution {
    static int arr[], subSheep, info2[],max = 0;
    static boolean visit2[];
    static ArrayList<Node> sheep;
    //순열 돌리기
    public static void permu(int start, int end, int cnt){
        if(cnt == end){
            max = Math.max(max,check(arr));
            return;
        }
        for(int i=0; i<end; i++){
            if(!visit2[i]){
                visit2[i] = true;
                arr[i] = cnt;
                permu(i,end,cnt+1);
                visit2[i] = false;
            }
        }
    }
    //순열돌린거 체크하기
    public static int check(int ar[]){
        int sheepNum = subSheep+1;
        int wolfNum = 0;
        boolean visit[] = new boolean[20];
        for(int i=0; i<ar.length; i++){
            Node node = sheep.get(ar[i]+subSheep);
            //System.out.print(node.num);
            int tempWolf = wolfNum;
            int tempSheep = sheepNum;
            ArrayList<Integer> visitList = new ArrayList<>();
            while(true){
                if(node.prev == null) break;
                else{
                    node = node.prev;
                    if(!visit[node.num])
                    if(info2[node.num] == 1) {
                        tempWolf++;
                        // visit[node.num] = true;
                        visitList.add(node.num);
                    }
                }
            }
            
            if(tempWolf< sheepNum){
                sheepNum++;
                wolfNum = tempWolf;
                for(int j=0; j<visitList.size(); j++){
                    visit[visitList.get(j)] = true;
                }
            }
        }
        return sheepNum;
    }
    public int solution(int[] info, int[][] edges) {
        info2 = info;
        int answer = 0;
        List<Integer> list[] = new ArrayList[info.length];
        //연결
        for(int i=0; i<info.length; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<edges.length; i++){
            int temp[] = edges[i];
            list[temp[0]].add(temp[1]);
        }
        //노드 생성 && SHEEP 위치 리스트에 넣기
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0,null,0));
        sheep = new ArrayList<>();
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i=0; i<list[node.num].size(); i++){
                Node temp = null;
                if(info[list[node.num].get(i)] == 1)
                    temp = new Node(list[node.num].get(i), node.depth+1, node,node.wn+1);
                else{
                    temp = new Node(list[node.num].get(i), node.depth+1, node,node.wn);  
                }
                q.add(temp);
                if(info[list[node.num].get(i)] == 0) sheep.add(temp);
            }
        }
        subSheep = 0;
        //붙어있는건 제외하고 순열만들기
        for(int i=0; i<sheep.size(); i++){
            Node node = sheep.get(i);
            if(node.wn == 0) {
                subSheep++;
                continue;
            }
            else{
                arr= new int[sheep.size()-subSheep];
                visit2 = new boolean[sheep.size()];
                permu(0,sheep.size()-subSheep,0);
                break;
            }
        }
        if(max == 0) max = subSheep+1;
        return max;
    }
}