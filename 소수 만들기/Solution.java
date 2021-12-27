class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        boolean arr[] = new boolean[45000];
        for(int i=2; i*i<45000; i++){
            if(!arr[i]){
                for(int j=i*i; j<45000; j+=i){
                    arr[j] = true;
                }
            }
        }
        
        int numLen = nums.length;
        for(int i=0; i<numLen; i++){
            for(int j=i; j<numLen; j++){
                if(j == i) continue;
                for(int k=j; k<numLen; k++){
                    if(k == j || k == i) continue;
                    int temp = nums[i] + nums[j] + nums[k];
                    if(!arr[temp]) answer++;
                }
            }
        }
        return answer;
    }
}