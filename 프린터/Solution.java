import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
    	Deque<Integer> dq = new LinkedList<>();
        int answer = 0;
        int max = 0;
        //���� ���ֱ�.
        for(int i=0; i<priorities.length; i++) {
        	dq.add(priorities[i]);
        }
        //ť�� ��������.
        while(!dq.isEmpty()) {
        	//System.out.println(dq+" "+location);
        	max = 0;
        //ť �ȿ��� �ִ� ã��
        for(int temp:dq) {
        	if(max < temp) max = temp;
        }
        
        for(int temp:dq) {
        	//�ִ밪�� ���� ���� �� ���� �ٸ���.
        	if(temp != max) {
        		if(location<=0) location = dq.size()-1;
        		else location--;
        		dq.addLast(dq.pollFirst());
        		break;
        	}
        	//�ִ밪�� ���� ������ ���� ������.
        	//location�� 0�̸� ���ϴ´�.
        	else {
        		dq.poll();
        		answer++;
        		if(location == 0) return answer;
        		if(location<=0) location = dq.size()-1;
        		else location--;
        		break;
        	}
        }
        }
        return answer;
    }

	public static void main(String args[]) throws IOException {
		Solution s = new Solution();
		int arr[] = {1,1,9,1,1,1};
		System.out.println(s.solution(arr, 0));
	}
}

