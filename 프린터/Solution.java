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
        //덱에 값넣기.
        for(int i=0; i<priorities.length; i++) {
        	dq.add(priorities[i]);
        }
        //큐가 빌때까지.
        while(!dq.isEmpty()) {
        	//System.out.println(dq+" "+location);
        	max = 0;
        //큐 안에서 최댓값 찾기
        for(int temp:dq) {
        	if(max < temp) max = temp;
        }
        
        for(int temp:dq) {
        	//최대값이 지금 빼야 할 값과 다를때.
        	if(temp != max) {
        		if(location<=0) location = dq.size()-1;
        		else location--;
        		dq.addLast(dq.pollFirst());
        		break;
        	}
        	//최대값이 지금 빼야할 값과 같을때.
        	//location이 0이면 원하는답.
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

