import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int first = commands[i][0];
            int end = commands[i][1];
            int resultIndex = commands[i][2];
            //정해진 범위만큼 리스트에 값넣기
            for(int j=first-1; j<=end-1; j++){
                list.add(array[j]);
            }
            //리스트 정렬
            Collections.sort(list);
            answer[i] = list.get(resultIndex-1);
        }
        return answer;
    }
}