import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
          pq.add(scoville[i]);  
        }
        while(pq.peek() < K){
            if(pq.size() > 2){
            int temp = pq.poll();
            int temp2 = pq.poll()*2;
            pq.add(temp + temp2);
            answer++;
            }
            else if(pq.size() == 2){
                int temp = pq.poll();
                int temp2 = pq.poll()*2;
                if(temp + temp2 < K){
                    answer = -1;
                    break;
                }
                else{
                    pq.add(temp + temp2);
                    answer++;
                }
            }
            
        }
        return answer;
    }
}