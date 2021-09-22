import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //최근에 넣은 값만 확인하므로 스택을 사용함.
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++){
            int num = moves[i];
            //정사각형틀만 주어지므로 board길이를 사용해도 괜찮음.
            for(int j=0; j<board.length; j++){
                if(board[j][num-1] == 0){
                    continue;
                }
                else{
                    if(!stack.isEmpty()){
                        if(stack.peek() == board[j][num-1]){
                        	//(제일 중요함)인형 2개씩 사라짐.
                            answer += 2;
                            stack.pop();
                            board[j][num-1] = 0;
                        }
                        else{
                            stack.add(board[j][num-1]);
                            board[j][num-1] = 0;
                        }
                    }
                    else{
                        stack.add(board[j][num-1]);
                        board[j][num-1] = 0;
                    }
                    //인형을 하나 뽑았다면 break해서 다음 뽑기로 넘어가야함.
                    break;
                }
            }
        }
        return answer;
    }
}