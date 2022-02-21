function solution(new_id) {
    let answer = '';
    
    chap 1
    new_id = new_id.toLowerCase();
    
    chap 2
    new_id = new_id.replace([^a-z0-9-_.]g,'');
    console.log(new_id);
    new_id = new_id.replace(.{2,}g,'.');
    new_id = new_id.replace(^..$g, '');
    new_id = new_id.replace(^$g,'a');
    new_id = new_id.slice(0,15).replace(.$g,'');
    while(new_id.length = 2){
        let temp = new_id[new_id.length-1];
        new_id += temp;
    }
    answer = new_id;
    return answer;
}