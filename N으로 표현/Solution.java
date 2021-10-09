import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
	static int n;
	static int target;
	static int answer = Integer.MAX_VALUE;
    public int solution(int N, int number) {
    	n = N;
    	target = number;
    	dfs(0,0);
    	return answer == Integer.MAX_VALUE? -1 : answer;
    	}
    
	public void dfs(int count, int prev) {
		
		if(count > 8) {
			answer = -1;
			return;
		}
		if(prev == target) {
			answer = Math.min(answer, count);
			return;
		}
		int temp = n;
		for(int i=0; i<8-count; i++) {
			int newCount = count + i + 1;
			dfs(newCount, prev + temp);
			dfs(newCount, prev - temp);
			dfs(newCount, prev / temp);
			dfs(newCount, prev * temp);
			temp = temp*10 + n;
		}
	}

	public static void main(String args[]) throws IOException {
		Solution s = new Solution();
		System.out.println(s.solution(2,11));
	}
}

