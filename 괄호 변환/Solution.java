import java.util.*;
class Solution {
	//올바른 괄호 문자열인지 확인하는 함수.
	//(일때는 +, )일때는 -인데, 한번이라도 음수가 된다면 해당 문자열은 올바른 괄호 문자열이 될 수 없다.
        boolean check(String temp){
            int count = 0;
            for(int i=0; i<temp.length(); i++){
                if(temp.charAt(i) == '('){
                    count++;
                }
                else{
                    count--;
                }
                if(count<0) return false;
            }
            return true;
        }
    public String solution(String p){
    	//비어있으면 그대로 종료.
        if(p.isEmpty()) return p;
        int count=0;
        String u="",v="";
        //균형잡힌 괄호 문자열이 나올때까지 더하다가 균형잡힌 문자열이 나오면 U,V값을 지정하고, 반복문 종료.
        for(int i=0; i<p.length();i++){
            if(p.charAt(i) =='('){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                u=p.substring(0,i+1);
                v=p.substring(i+1);
                break;
            }
        }
        //U가 올바른 괄호 문자열이라면, 문제의 3-1과정을 수행한다.
        if(check(u)){ 
         return u+solution(v);
        }
        //U가 올바른 괄호 문자열이 아니라면 4-1,4-2,4-3,4-4,4-5과정을 수행합니다.
        String result = "(" + solution(v) +")";
        for(int i=1; i<u.length()-1; i++){
            if(u.charAt(i) == '('){
                result += ')';
            }
            else{
                result += '(';
            }
        }
        return result;
    }
}