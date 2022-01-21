import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> hm1 = new HashMap<>();
        HashMap<String,Set<String>> hm2 = new HashMap<>();
        //hm1 A가 신고당한 횟수
        //hm2 A가 신고한 목록 A->{ }
        for(int i=0; i<id_list.length; i++){
            hm1.put(id_list[i],0);
            hm2.put(id_list[i],new HashSet<String>());
        }
        
        for(int i=0; i<report.length; i++){
            StringTokenizer st = new StringTokenizer(report[i]," ");
            String reporter = st.nextToken();
            String reported = st.nextToken();
            //신고한 목록에 넣기 + 해당 유저 신고당한 횟수 + 1
            if(hm2.get(reporter).add(reported)){
                hm1.put(reported,hm1.get(reported)+1);
            }
        }
        //K보다 적게 신고 당한 사람 신고목록에서 지우기
        for(int i=0; i<id_list.length; i++){
            if(hm1.get(id_list[i]) < k){
                for(int j=0; j<hm2.size(); j++){
                    hm2.get(id_list[j]).remove(id_list[i]);
                }
            }
        }
        for(int i=0; i<id_list.length; i++){
            answer[i] = hm2.get(id_list[i]).size();
        }
        return answer;
    }
}