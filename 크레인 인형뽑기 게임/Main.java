import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        //�ֱٿ� ���� ���� Ȯ���ϹǷ� ������ �����.
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<moves.length; i++){
            int num = moves[i];
            //���簢��Ʋ�� �־����Ƿ� board���̸� ����ص� ������.
            for(int j=0; j<board.length; j++){
                if(board[j][num-1] == 0){
                    continue;
                }
                else{
                    if(!stack.isEmpty()){
                        if(stack.peek() == board[j][num-1]){
                        	//(���� �߿���)���� 2���� �����.
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
                    //������ �ϳ� �̾Ҵٸ� break�ؼ� ���� �̱�� �Ѿ����.
                    break;
                }
            }
        }
        return answer;
    }
}