import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt = 0;
        int zeroCnt = 0;
        for(int i=0; i<6; i++){
            if(lottos[i] == 0){
                zeroCnt++;
                continue;
            }
            for(int j=0; j<6; j++){
                if(win_nums[j] == lottos[i]){
                    cnt++;
                    break;
                }
            }
        }
        //7등에서 기본값1을 빼서 6등부터 시작하여, 6,5,4,3,2,1등순으로
        answer[0] = 7 - Math.max(cnt+zeroCnt,1);
        answer[1] = 7 - Math.max(cnt,1);
        return answer;
    }
}