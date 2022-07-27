function solution(dartResult) {
    var answer = 0;
    let nums = [];
    let val = 0;
    for(let i=0; i<dartResult.length; i++){
        if(dartResult[i] >=0 && dartResult[i] <=9){
            if(dartResult[i] == 1 && dartResult[i+1] == 0){
                i++;
                val = 10;
            }
            else{
                val = dartResult[i];
            }
        }
        else if(dartResult[i] == 'S'){
            nums.push(val);
        }
        else if(dartResult[i] == 'D'){
            nums.push(Math.pow(val,2));
        }
        else if(dartResult[i] == 'T'){
            nums.push(Math.pow(val,3));
        }
        else if(dartResult[i] === '*'){
            nums[nums.length-1] *= 2;
            nums[nums.length-2] *= 2;
        }
        else if(dartResult[i] === '#'){
            nums[nums.length-1] *= -1;
        }
    }
    for(let i=0; i<nums.length; i++){
        answer += Number(nums[i]);
    }
    return answer;
}