function solution(s) {
    var answer = 0;
    let stack = [];
    let right = false;
    if(s.length %2 == 1) return 0;
    for(let i=0; i<s.length; i++){
        right = true;
        let nowS = s.slice(i) + s.slice(0,i);
        for(let word of nowS){
            if(word == '(' || word=='[' || word=='{') stack.push(word);
            else{
                let prevWord = stack.pop();
                if(word ==')' && prevWord == '(') continue;
                if(word ==']' && prevWord == '[') continue;
                if(word == '}' && prevWord == '{') continue;
                right = false;
                break;
            }
        }
        if(right) answer++;
    }
    return answer;
}