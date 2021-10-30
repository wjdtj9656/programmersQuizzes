import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion){
        HashMap<String,Integer> hm = new HashMap<>();
        String answer = "";
        
	    	for(int i=0; i<participant.length; i++) {
	    		//null���̸� ���� 1�� �־���.
	    		if(hm.get(participant[i]) == null) {
	    			hm.put(participant[i], 1);
	    		}
	    		//null���� �ƴϸ� �������� 1�߰�
	    		else {
	    			hm.put(participant[i],hm.get(participant[i])+1);
	    		}
	    	}
	    	
            for(int i=0; i<completion.length; i++) {
	    		hm.put(completion[i],hm.get(completion[i])-1);
	    	}
            
	    	for(int i=0; i<hm.size(); i++) {
	    		if(hm.get(participant[i]) != 0) {
	    			return participant[i];
	    		}
	    	}
        return answer;
    }
}