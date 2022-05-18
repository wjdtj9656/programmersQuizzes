import java.util.*;
class Node{
    int now;
    int cnt;
    public Node(int now, int cnt){
        this.now = now;
        this.cnt = cnt;
    }
}
class Solution {
    static ArrayList<Integer> list[];
    static boolean visit[];
    static int max = 0;
    static int answer = 0;
    public static void bfs(int start){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start,0));
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(max < temp.cnt){
                max = temp.cnt;
                answer = 0;
            }
            if(temp.cnt == max) answer++;
            for(int i=0; i<list[temp.now].size(); i++){
                if(!visit[list[temp.now].get(i)]){
                    visit[list[temp.now].get(i)] = true;
                    q.add(new Node(list[temp.now].get(i),temp.cnt+1));
                }
            }
        }
    }
    public int solution(int n, int[][] edge) {
        int max = 0;
        list = new ArrayList[n];
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]-1].add(edge[i][1]-1);
            list[edge[i][1]-1].add(edge[i][0]-1);
        }
        visit[0] = true;
        bfs(0);
        
        return answer;
    }
}