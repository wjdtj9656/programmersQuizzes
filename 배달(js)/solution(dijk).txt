function solution(N, road, K) {
    var answer = 0;
    const visit = new Array(N).fill(false);
    const dis = new Array(N).fill(Infinity);
    const arr = new Array(N).fill(Infinity).map(()=>new Array(N).fill(Infinity));
    for(let i=0; i<road.length; i++){
        const [a,b,c] = road[i];
        arr[a-1][b-1] = Math.min(arr[a-1][b-1],c);
        arr[b-1][a-1] = Math.min(arr[a-1][b-1],c);
    }
    const searchIndex = () =>{
        let min = Infinity;
        let res = 0;
        for(let i=0; i<N; i++){
            if(visit[i]) continue;
            if(min > dis[i]){
                min = dis[i];
                res = i;
            }
        }
        return res;
    }
    dis[0] = 0;
    visit[0] = true;
    for(let i=0; i<N; i++){
        let index = searchIndex();
        visit[index] = true;
        for(let j=0; j<N; j++){
            if(visit[j]) continue;
            if(dis[j] > dis[index] + arr[index][j]){
                dis[j] = dis[index] + arr[index][j];
            }
        }
    }
    for(let i=0; i<N; i++){
        if(dis[i] <= K) answer++;
    }
    return answer
}