import java.util.*;
class Solution {
	//�ùٸ� ��ȣ ���ڿ����� Ȯ���ϴ� �Լ�.
	//(�϶��� +, )�϶��� -�ε�, �ѹ��̶� ������ �ȴٸ� �ش� ���ڿ��� �ùٸ� ��ȣ ���ڿ��� �� �� ����.
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
    	//��������� �״�� ����.
        if(p.isEmpty()) return p;
        int count=0;
        String u="",v="";
        //�������� ��ȣ ���ڿ��� ���ö����� ���ϴٰ� �������� ���ڿ��� ������ U,V���� �����ϰ�, �ݺ��� ����.
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
        //U�� �ùٸ� ��ȣ ���ڿ��̶��, ������ 3-1������ �����Ѵ�.
        if(check(u)){ 
         return u+solution(v);
        }
        //U�� �ùٸ� ��ȣ ���ڿ��� �ƴ϶�� 4-1,4-2,4-3,4-4,4-5������ �����մϴ�.
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