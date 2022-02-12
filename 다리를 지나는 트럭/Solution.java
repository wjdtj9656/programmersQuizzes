import java.util.*;
import java.io.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) throws Exception{
        Queue<Integer> q = new ArrayDeque<>();
        int time = 0;
        int idx = 0;
        int nowWeight = 0;
        while(true){
            //������ Ʈ�� �ö󰡸� ����
            if(idx == truck_weights.length) break;
            
            //���� ������ �����
            if(q.size() == bridge_length) nowWeight -= q.poll();
            
            //���� Ʈ���� ������,,, 0�� �־ Ʈ���� �����Ѱ�ó�� ���̰���.
            else if(nowWeight+truck_weights[idx] > weight){
                q.add(0);
                time++;
            }
            //Ʈ���� ��
            else{
                q.add(truck_weights[idx]);
                nowWeight += truck_weights[idx];
                time++;
                idx++;
            }
        }
        time += bridge_length;
        return time;
        
    }
}