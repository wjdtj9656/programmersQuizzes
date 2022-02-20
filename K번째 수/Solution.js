function solution(array, commands) {
    var answer = [];
    let index2 = 0;
    for(let temp of commands){
        let arr = [];
        let index = 0;
        for(let i=temp[0]; i<=temp[1]; i++){
            arr[index++] = array[i-1];
        }
        arr.sort((a,b)=>a-b);
        answer[index2++] = arr[temp[2]-1];
    }
    return answer;
}