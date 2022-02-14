import java.util.*;
import java.io.*;
class Solution {
    static int N;
    static int arr[];
    //static ArrayList<Integer> list;
    static int result[];
    static boolean visit[];
    static String temp="0";
    static Set<Integer> set;
    public static void search(int cnt){
            for(int i=0; i<cnt; i++){
                if(result[0] == 0) return;
                //System.out.print(result[i]);
                temp += result[i];
            }
            int num = Integer.parseInt(temp);
            boolean flag = false;
            if(num == 2) set.add(num);
            for(int i=2; i<num; i++){
                if(num % i == 0) {
                    flag = false;
                    break;
                }
                flag = true;
            }
                if(flag){
                    set.add(num);
                    System.out.println(num);
                }
        
        for(int i=0; i<arr.length; i++){
            if(visit[i]) continue;
            temp="";
            visit[i] = true;
            result[cnt] = arr[i];
           // list.add(arr[i]);
            search(cnt+1);
            visit[i] = false;
        }
    }
    public int solution(String numbers) {
        int answer = 0;
        N = numbers.length();
        arr = new int[N];
        visit = new boolean[N];
        //list = new Array<>();
        result = new int[N];
        set = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            arr[i] = numbers.charAt(i) - '0';
        }
        search(0);
        answer = set.size();
        return answer;
    }
}