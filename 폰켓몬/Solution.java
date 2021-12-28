import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int pick = nums.length / 2;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(list.size() == pick) break;
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
        }
        answer = list.size();
        return answer;
    }
}