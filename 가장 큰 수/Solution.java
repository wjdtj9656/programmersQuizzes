import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		
		String str[] = new String[numbers.length];
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length; i++) {
			str[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
		});
		if(str[0].charAt(0) == '0') return "0";
		for(int i=0; i<str.length; i++) {
			sb.append(str[i]);
		}
		return sb.toString();
	}
	public static void main(String args[]) throws IOException {
		int arr[] = {0,0,0};
		Solution s = new Solution();
		System.out.println(s.solution(arr));
	}
}

