import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int size = stages.length;
        double[] arr = new double[N];
        double[] sortArr = new double[N];
        for(int i=1; i<=N; i++){
            int temp = 0;
            for(int j=0; j<stages.length; j++){
              if(stages[j] == i){
                  temp++;
              }  
            }
            if(size == 0) size++;
            arr[i-1] =(double)temp / (double)size;
           // System.out.println(arr[i-1]+" "+temp+" "+size);
            sortArr[i-1] =(double)temp / (double)size;
            size -= temp;
        }
        Arrays.sort(sortArr);
        
        for(int i=0; i<N; i++){
            double max = sortArr[N-i-1];
            for(int j=0; j<N; j++){
                if(arr[j] == max){
                    answer[i] = j+1;
                    arr[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}