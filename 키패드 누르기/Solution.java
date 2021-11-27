import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int leftLocation = 10;
        int rightLocation = 12;
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 0) numbers[i] = 11;
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                leftLocation = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                rightLocation = numbers[i];
            }
            else{
                int leftLen = getLength(leftLocation, numbers[i]);
                int rightLen = getLength(rightLocation, numbers[i]);
                
                if(leftLen > rightLen){
                    sb.append("R");
                    rightLocation = numbers[i];
                }
                else if(leftLen < rightLen){
                    sb.append("L");
                    leftLocation = numbers[i];
                }
                else{
                    if(hand.equals("right")){
                        sb.append("R");
                        rightLocation = numbers[i];
                    }
                    else{
                        sb.append("L");
                        leftLocation = numbers[i];
                    }
                }
            }
        }
        answer = sb.toString();
        return answer;
        }
    public static int getLength(int index, int number){
        index = (index == 0) ? 11 : index;
        number = (number == 0) ? 11 : number;
        
        int x = (index - 1) / 3;
        int y = (index - 1) % 3;
        int numX = number / 3;
        int numY = 1;
        return Math.abs(x-numX) + Math.abs(y-numY);
    }
}