import java.util.*;
class Solution {
    public boolean binarySol(int stones[], int k, int mid){
        int cnt = 0;
        for(int stone : stones){
            if(stone < mid){
                cnt++;
            }
            else{
                cnt = 0;
            }
            if(cnt == k) return false;
        }
        return true;
    }
    public int solution(int[] stones, int k) {
        int answer = (int)1e9;
        int start = 1;
        int end = 200000000;
        while(start <= end){
            int mid = (start + end)/2;
            if(binarySol(stones, k, mid)){
                answer = mid;
                start = mid +1 ;
            }
            else{
                end = mid - 1;
            }
        }
        return answer;
    }
}