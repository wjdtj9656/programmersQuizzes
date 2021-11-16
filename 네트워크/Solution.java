class Solution {
    static boolean visit[];
    static int result;
    static boolean check;
    
    static void dfs(int x, int n, int computer[][]){
       for(int i=0; i<n; i++){
           if(visit[i] == false){
               if(x == i) check = true;
           }
           if(computer[x][i] == 1 && visit[i] == false){
               visit[x] = true;
               dfs(i,n,computer);
               check = true;
           }
       } 
    }
    public int solution(int n, int[][] computers) {
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            check = false;
            dfs(i, n, computers);
            if(check == true) result++;
        }
        return result;
    }
}