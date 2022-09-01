function solution(n, results) {
    let answer = 0;
    const arr = Array.from(Array(n+1), () => Array(n + 1).fill(987654321));
     console.log(arr);
    for(let winLose of results){
        let [win,lose] = winLose;
        arr[win][lose] = 1;
        arr[lose][win] = -1;
        arr[win][win] = 0;
        arr[lose][lose] = 0;
    }
    for(let k=1; k<=n; k++){
        for(let i=1; i<=n; i++){
            for(let j=1; j<=n; j++){
                    if(arr[i][k] == 1 && arr[k][j] == 1) arr[i][j] = 1;
                    if(arr[i][k] == -1 && arr[k][j] == -1) arr[i][j] = -1;
            }
        }
    }
    console.log(arr);
    for(let i=1; i<=n; i++){
        let check = false;
        for(let j=1; j<=n; j++){
            if(arr[i][j] === 987654321) {check = true; break;}
        }
        if(!check) answer++;
    }
    return answer;
}