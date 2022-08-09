function solution(maps) {
    var answer = 0;
    let dx = [-1,1,0,0];
    let dy = [0,0,-1,1];
    let size1 = maps.length;
    let size2 = maps[0].length;
    let visit = new Array(size1);
    for(let i=0; i<size1; i++){
        visit[i] = new Array(size2).fill(false);
    }
    visit[0][0] = true;
    
    function bfs(){
        let q = [];
        q.push([0,0,1]);
        while(q.length != 0){
            let [x,y,nCnt] = q.shift();
            if(x == size1-1 && y == size2-1) {
                return nCnt;
            }
            for(let i=0; i<4; i++){
                let nx = x+dx[i];
                let ny = y+dy[i];
                if(nx<0 || ny<0 ||nx>=size1 || ny>=size2 || visit[nx][ny] || maps[nx][ny] == 0) continue;
                visit[nx][ny] = true;
                q.push([nx,ny,nCnt+1])
            }
        }
    }
    answer = bfs();
    if(!answer) answer = -1;
    return answer;
}