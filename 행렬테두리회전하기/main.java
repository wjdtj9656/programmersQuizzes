class Solution {
    static int map[][];
    public static int rotate(int []query){
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        int standard = map[x1][y1];
        int min = (int)1e9;
        for(int i=x1; i<x2; i++){
            map[i][y1] = map[i+1][y1];
            min = Math.min(map[i+1][y1],min);
        }
        for(int i=y1; i<y2; i++){
            map[x2][i] = map[x2][i+1];
            min = Math.min(map[x2][i+1],min);
        }
        for(int i=x2; i>x1; i--){
            map[i][y2] = map[i-1][y2];
            min = Math.min(map[i-1][y2],min);
        }
        for(int i=y2; i>y1; i--){
            map[x1][i] = map[x1][i-1];
            min = Math.min(map[x1][i-1],min);
        }
        map[x1][y1+1] = standard;
        min = Math.min(map[x1][y1+1],min);
        return min;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = num++;
            }
        }
        for(int i=0; i<queries.length; i++){
            answer[i] = rotate(queries[i]);
        }
        return answer;
    }
}