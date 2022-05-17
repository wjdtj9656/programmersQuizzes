import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        //한번 돌면서 set 최대크기 찾기.
        for(int i=0; i<gems.length; i++){
            set.add(gems[i]);
        }
        int size = set.size();
        set.clear();
        
        int start = 0;
        int end = 0;
        int min = (int)10e9;
        int result1 = 0;
        int result2 = 0;
        set.add(gems[0]);
        while(start<=end){
            //목표 사이즈와 같을 때
            if(set.size() == size) {
                //최소 구간 찾는 과정
                if(min > end-start){
                    min = end - start;
                    result1 = start;
                    result2 = end;
                }
                //set을 사용하니 remove하면 없애면 안되는 값들도 다 없애버려서,,
                //없애면 안되는 값을 없앴다면 다시 추가해줌.
                String temp = gems[start];
                set.remove(gems[start]);
                start+=1;
                for(int i=start; i<=end; i++){
                    if(gems[i].equals(temp)){
                        set.add(temp);
                        break;
                    }
                }
                if(start == gems.length) break;
                set.add(gems[start]);
            }
            else if(set.size() < size){
                end+=1;
                if(end == gems.length) break;
                set.add(gems[end]);
            }
            else if(set.size() > size){
                //set을 사용하니 remove하면 없애면 안되는 값들도 다 없애버려서,,
                //없애면 안되는 값을 없앴다면 다시 추가해줌.
                String temp = gems[start];
                set.remove(gems[start]);
                start+=1;
                for(int i=start; i<=end; i++){
                    if(gems[i].equals(temp)){
                        set.add(temp);
                        break;
                    }
                }
                if(start == gems.length) break;
                set.add(gems[start]);
            }
        }
        answer[0] = result1+1;
        answer[1] = result2+1;
        return answer;
    }
}