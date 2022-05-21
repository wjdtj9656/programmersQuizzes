import java.util.*;
class Node{
    int x;
    int y;
    int dis;
    //origin
    int ox, oy;
    public Node(int x, int y, int dis, int ox, int oy){
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.ox = ox; 
        this.oy = oy;
    }
}
class Solution {
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        boolean visit[][] = new boolean[5][5];
        Arrays.fill(answer,1);
        for(int i=0; i<5; i++){
            Queue<Node> q = new LinkedList<>();
            char map[][] = new char[5][5];
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    map[j][k] = places[i][j].charAt(k);
                    if(map[j][k] == 'P') {
                        q.add(new Node(j,k,0,0,0));
                        visit[j][k] = true;
                    }
                }
            }
            while1:
            while(!q.isEmpty()){
                Node node = q.poll();
                int saveX = 0;
                int saveY = 0;
                if(map[node.x][node.y] == 'P'){
                    saveX = node.x;
                    saveY = node.y;
                }
                for(int a=0; a<4; a++){
                    int nx = node.x + dx[a];
                    int ny = node.y + dy[a];
                    if(nx<0 || ny<0 || nx>=5 || ny>=5 || map[nx][ny] == 'X' || node.dis>=2) continue;
                    //처음지점으로 돌아가는거 방지
                    if(node.ox == nx && node.oy == ny) continue;
                    if(node.dis<=2 && map[nx][ny] == 'P'){
                        answer[i] = 0;
                        break while1;
                    }
                    q.add(new Node(nx,ny,node.dis+1,saveX,saveY));
                }
            }
        }
        return answer;
    }
}