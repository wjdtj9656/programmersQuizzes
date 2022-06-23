class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        int origin = price;
        while(count > 0){
            count--;
            sum += price;
            price += origin;
        }
        if(sum - money <= 0) return 0;
        return sum - money;
    }
}