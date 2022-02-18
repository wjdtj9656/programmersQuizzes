import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int value = citations[citations.length-1];
        for(int i=value; i>=0; i--){
            int temp = i;
            int cnt = 0;
            for(int j : citations){
                if( j >= temp) cnt++;
            }
            if(cnt >= temp && citations.length-cnt <=cnt){
                answer = temp;
                break;
            }
        }
        return answer;
    }
}