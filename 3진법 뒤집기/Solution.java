import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";
        StringBuilder sb = new StringBuilder();
        while(n/3 > 0){
            temp = n%3 + temp;
            n /= 3;            
        }
        temp = n + temp;
        sb.append(temp);
        sb.reverse();
        int mul = 1;
        for(int i=sb.length()-1; i>=0; i--){
            answer += (sb.charAt(i) -'0') * mul;
            mul *= 3;
        }
        return answer;
    }
}