import java.util.*;
class Solution {
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        HashMap<Integer,Integer> hm = new HashMap<>();
        boolean visit[] = new boolean[n];
        int save[] = new int[n];
        
        for(int i=0; i<order.length; i++){
            if(order[i][1] == 0) return false;
            hm.put(order[i][1], order[i][0]);
        }
        ArrayList<Integer> list[] = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<path.length; i++){
            list[path[i][0]].add(path[i][1]);
            list[path[i][1]].add(path[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        visit[0] = true;
        for(int i=0; i<list[0].size(); i++){
            q.add(list[0].get(i));
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(visit[cur]) continue;
            if(hm.get(cur) != null){
                if(!visit[hm.get(cur)]){
                    save[hm.get(cur)] = cur;
                    continue;
                }
            }
            visit[cur] = true;
            for(int i=0; i<list[cur].size(); i++){
                q.add(list[cur].get(i));
            }
            
            q.add(save[cur]);
        }
        for(boolean i : visit){
            if(i == false){
                answer = false;
                break;
            }
        }
        return answer;
    }
}