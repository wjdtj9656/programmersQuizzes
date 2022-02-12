import java.util.*;
import java.io.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) throws Exception{
        Queue<Integer> q = new ArrayDeque<>();
        int time = 0;
        int idx = 0;
        int nowWeight = 0;
        while(true){
            //마지막 트럭 올라가면 종료
            if(idx == truck_weights.length) break;
            
            //길이 꽉차면 비워줌
            if(q.size() == bridge_length) nowWeight -= q.poll();
            
            //다음 트럭이 못들어가면,,, 0을 넣어서 트럭이 전진한것처럼 보이게함.
            else if(nowWeight+truck_weights[idx] > weight){
                q.add(0);
                time++;
            }
            //트럭이 들어감
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