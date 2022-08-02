function solution(expression) {
    var answer = 0;
    let prior =[
        [0,1,2],
        [0,2,1],
        [1,2,0],
        [1,0,2],
        [2,0,1],
        [2,1,0]
    ]
    let prior2 ={
        0:'+',
        1:'*',
        2:'-'
    }
    for(let opers of prior){
        let nowExpression = expression.split(/(\D)/);
        for(let oper of opers){
            while(nowExpression.includes(prior2[oper])){
                let index = nowExpression.indexOf(prior2[oper]);
                let value = 0;
                if(oper == 0){
                    value = Number(nowExpression[index-1]) + Number(nowExpression[index+1]);
                }
                else if(oper == 1){
                    value = Number(nowExpression[index-1]) * Number(nowExpression[index+1]);
                }
                else{
                    value = Number(nowExpression[index-1]) - Number(nowExpression[index+1]);
                }
                nowExpression.splice(index-1,3,value);
            }
            if(nowExpression.length == 1){
                answer = Math.max(Math.abs(Number(nowExpression)),answer);
            }
        }
    }
    return answer;
}