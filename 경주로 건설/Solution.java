import java.util.*;

class Solution {
    static int map[][], N, min =(int)1e9;
    //위 좌 아래 우
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int visit[][][];
    public static void dfs(int x, int y, int dir, int cost){
        if(x == N-1 && y == N-1){
            min = Math.min(min, cost);
            return;
        }
        if(cost > min) return;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny] == 1) continue;
            if(visit[nx][ny][i] < cost) continue;
            int origin = cost;
            if(dir%2 == 0 && i%2 ==1){
                if(cost!=0)
                cost += 500;
                cost += 100;
            }
            else if(dir%2 == 1 && i%2 == 0){
                if(cost!=0)
                cost += 500;
                cost += 100;
            }
            else{
                cost += 100;
            }
            
            visit[nx][ny][i] = cost;
            dfs(nx, ny, i, cost);
            cost = origin;
        }
    }
    public int solution(int[][] board) {
        map = board;
        N = board.length;
        visit = new int[N][N][4];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<4; k++){
                    visit[i][j][k] = (int)10e9;
                }
            }
        }
        dfs(0,0,0,0);
        int answer = min;
        //         for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.println(visit[i][j]);
        //     }
        // }
        return answer;
    }
}