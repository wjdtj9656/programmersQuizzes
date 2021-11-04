import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        //�۾��Ϸ� �ɸ��� �ð� �輭�ؼ� ť�� �ֱ�
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
        //ť�� �ð�������� ����Ͽ� ���������� ���������� sum ����ؼ� ����Ʈ�� �ֱ�
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
        
        //����Ʈ�� ���� answer�� �ű��
        int answer[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}