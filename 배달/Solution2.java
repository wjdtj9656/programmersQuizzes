import java.util.*;
class Node implements Comparable<Node>{
    int to;
    int dis;
    public Node(int to, int dis){
        this.to = to;
        this.dis = dis;
    }
    public int compareTo(Node o1){
        return this.dis - o1.dis;
    }
}
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int dist[] = new int[N];
        ArrayList<Node> list[] = new ArrayList[N];
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<road.length; i++){
            list[road[i][1]-1].add(new Node(road[i][0]-1,road[i][2]));
            list[road[i][0]-1].add(new Node(road[i][1]-1,road[i][2]));
        }
        Arrays.fill(dist,(int)1e9);
        dist[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(cur.dis > dist[cur.to]) continue;
            for(int i=0; i<list[cur.to].size(); i++){
                Node next = list[cur.to].get(i);
                if(dist[next.to] > cur.dis + next.dis){
                    dist[next.to] = cur.dis + next.dis;
                    pq.add(new Node(next.to,dist[next.to]));
                }
            }
        }
        for(int i=0; i<N; i++){
            //System.out.println(dist[i]);
            if(dist[i] <= K) answer++;
        }
        return answer;
    }
}