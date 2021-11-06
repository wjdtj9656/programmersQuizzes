import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> hm = new HashMap<>();
        String[][] alert = new String[record.length][3];
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i]);
            alert[i][0] = st.nextToken();
            alert[i][1] = st.nextToken();
            
            if(alert[i][0].equals("Leave")){
                continue;
            }
            else{
                alert[i][2] = st.nextToken();
                hm.put(alert[i][1],alert[i][2]);    
            }
            
        }
        for(int i=0; i<record.length; i++){
            if(alert[i][0].equals("Enter")){
                list.add(hm.get(alert[i][1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
            }
            else if(alert[i][0].equals("Leave")){
                list.add(hm.get(alert[i][1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
            }
        }
        String answer[] = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}