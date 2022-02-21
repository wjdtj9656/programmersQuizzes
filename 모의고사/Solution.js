function solution(answers) {
    var answer = [];
    let keys = {
        'one' : [1,2,3,4,5],
        'two' : [2,1,2,3,2,4,2,5],
        'three' : [3,3,1,1,2,2,4,4,5,5]
    }
    let one=0,two=0,three=0;
    for(let i=0; i<answers.length; i++){
        if(keys['one'][i%5] == answers[i]) one++;
        if(keys['two'][i%8] == answers[i]) two++;
        if(keys['three'][i%10] == answers[i]) three++;
    }
    let max = Math.max(one,Math.max(two,three));
    let result = [];
    result[0] = one;
    result[1] = two;
    result[2] = three;
    for(let i=0; i<3; i++){
        if(result[i] === max) {
            answer.push(i+1);
        }
    }
    return answer;
}