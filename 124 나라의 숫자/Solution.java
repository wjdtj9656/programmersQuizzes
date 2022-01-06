class Solution {
    public String solution(int n) {
        String answer = "";
        String temp[] = {"4", "1", "2"};
        while(n > 0){
            int save = n%3;
            answer = temp[save] + answer;
            
            n /= 3;
            if(save == 0) n-=1;
            
        }
        return answer;
    }
}