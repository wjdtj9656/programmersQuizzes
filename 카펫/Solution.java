class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int all = brown + yellow;
        
        int n = 3;
        int m = 3;
        for(; n*m<=all; n++){
            for(; n*m<=all ; m++){
                if(n*m == all && m>=n){
                    if( (n-2) * (m-2) == yellow){
                    answer[0] = m;
                    answer[1] = n;
                    }
                }
            }
            m=3;
        }
        return answer;
    }
}