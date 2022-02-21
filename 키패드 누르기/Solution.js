function solution(numbers, hand) {
    var answer = '';
    const keys = {
        1: [0, 0],
        2: [0, 1],
        3: [0, 2],
        4: [1, 0],
        5: [1, 1],
        6: [1, 2],
        7: [2, 0],
        8: [2, 1],
        9: [2, 2],
        '*': [3, 0],
        0: [3, 1],
        '#': [3, 2]
    };
    
    let nowL = [3,0];
    let nowR = [3,2];
    for(let num of numbers){
        if(num % 3 === 1 ) {
            answer += 'L';
            nowL = keys[num];
        }
        else if(num % 3 === 0 && num !== 0){
            answer += 'R';
            nowR = keys[num];
        }
        else{
            let a,b;
            [a,b] = nowR;
            let temp = keys[num];
            let len1 = Math.abs(temp[0]-a) + Math.abs(temp[1]-b);
            [a,b] = nowL;
            let len2 = Math.abs(temp[0]-a) + Math.abs(temp[1]-b);
            if(len1 > len2){
                answer += 'L';
                nowL = temp;
            }
            else if(len1 < len2){
                answer += 'R';
                nowR = temp;
            }
            else{
                if(hand === 'right'){
                    answer += 'R';
                    nowR = temp;
                }
                else{
                    answer += 'L';
                    nowL = temp;
                }
            }
        }
    }
    return answer;
}