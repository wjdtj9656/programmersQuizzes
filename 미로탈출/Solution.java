import java.util.*;
class Solution {
    static int map[][] = new int[1001][1001];
    public static int dijkstra(int n, int start, int end, int traps[]){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        boolean visit[][] = new boolean[1001][1<<10];
        pq.add(new int[]{0,start,0});
        
        while(!pq.isEmpty()){
            int cur[] = pq.poll();
            int w = cur[0];
            int u = cur[1];
            int state = cur[2];
            
            if(u == end) return w;
            if(visit[u][state]) continue;
            visit[u][state] = true;
            boolean curTrap = false;
            HashMap<Integer, Boolean> hm = new HashMap<>();
            for(int i=0; i<traps.length; i++){
                int bit = 1<<i;
                if((state & bit) != 0){
                    if(traps[i] == u){
                        state &= ~bit;
                    }
                    else{
                        hm.put(traps[i],true);
                    }
                }
                else{
                    if(traps[i] == u){
                        state |= bit;
                        curTrap=true;
                        hm.put(traps[i],true);
                    }
                }
            }
            for(int v=1; v<=n; v++){
                if(v==u) continue;
                boolean nextTrap = hm.containsKey(v) ? true: false;
                if(curTrap == nextTrap){
                    if(map[u][v] != (int)1e9)
                    pq.add(new int[]{w+map[u][v],v,state});
                }
                else{
                    if(map[v][u] != (int)1e9)
                    pq.add(new int[]{w+map[v][u],v,state});
                }
            }
        }
        return (int)1e9;
    }
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
      for(int i=1; i<=n; i++){
          for(int j=1; j<=n; j++){
              if(i==j) continue;
              map[i][j] = (int)1e9;
          }
      }
        for(int data[] : roads){
            int u = data[0];
            int v = data[1];
            int w = data[2];
            if(w < map[u][v]){
                map[u][v] = w;
            }
        }
        return dijkstra(n,start,end,traps);
    }
}