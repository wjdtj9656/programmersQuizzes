function solution(n, lost, reserve) {
    var answer = 0;
    let stu = [];
    for(let i=0; i<n; i++){
        stu[i] = 1;
    }
    for(let i of lost){
        stu[i-1] -= 1;
    }
    for(let i of reserve){
        stu[i-1] += 1;
    }
    for(let i=0; i<n; i++){
        if(stu[i] === 0){
            if(i==0 && (stu[i+1] >= 2)){
                stu[i]++;
                stu[i+1]--;
            }
            else if(i == n-1 && (stu[i-1] >= 2)){
                stu[i-1]--;
                stu[i]++;
            }
           else if(stu[i-1] >= 2){
               stu[i-1]--;
               stu[i]++;
           } 
            else if(stu[i+1] >= 2){
                stu[i+1]--;
                stu[i]++;
            }
        }
    }
    for(let result of stu){
        if(result > 0) answer++;
    }
    return answer;
}