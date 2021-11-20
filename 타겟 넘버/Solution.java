class Solution {
    static int result = 0;
    static void dfs(int[] numbers, int depth,int num, int target){
        if(depth == numbers.length){
            if(num == target) result++;
            return;
         }
        num += numbers[depth];
        dfs(numbers, depth+1, num, target);
        num -= numbers[depth];
        num += (-1 * numbers[depth]);
        dfs(numbers, depth+1, num, target);
    }
    public int solution(int[] numbers, int target) {
        int depth = 0;
        dfs(numbers, 0, 0, target);
        return result;
    }
}