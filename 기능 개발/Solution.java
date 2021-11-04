import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        //작업완료 걸리는 시간 계서해서 큐에 넣기
        for(int i=0; i<progresses.length; i++){
            int progress = progresses[i];
            int speed = speeds[i];
            int workTime[] = new int[progresses.length];
            int time = 0;
            while(true){
                if(progress >= 100) break;
                progress += speed;
                time++;
            }
            workTime[i] = time;
            dq.add(time);
        }
        //큐의 시간순서대로 계산하여 다음값보다 작을때까지 sum 계산해서 리스트에 넣기
        int temp = 0;
       while(!dq.isEmpty()){
           int sum = 1;
           temp = dq.poll();
           int size = dq.size();
           for(int i=0; i<size; i++){
               if(temp < dq.peek()) break;
               else{
                   dq.poll();
                   sum++;
               }
           }
           list.add(sum);
       }
        
        //리스트를 정답 answer에 옮기기
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}