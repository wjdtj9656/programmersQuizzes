function solution(priorities, location) {
    var answer = 0;
    let max = 0;
    let turn = 0;
    while(true){
        max = 1;
        for(let num of priorities){
            max = Math.max(num, max);
        }
        if(max === priorities[0]){
            turn++;
            priorities.shift();
            if(location === 0) return turn;
            else location--;
        }
        else{
            priorities.push(priorities.shift());
            if(location === 0) location = priorities.length-1;
            else location--;
        }
    }
}