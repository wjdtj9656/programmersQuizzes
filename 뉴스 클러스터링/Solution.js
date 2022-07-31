function solution(str1, str2) {
    var answer = 0;
     str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        // console.log(str1);
        // console.log(str2);
    let arr1 = [];
    let arr2 = [];
    let regex = /([A-Z][A-Z])/g;
    for(let i=0; i<str1.length-1; i++){
        let now = str1.slice(i,i+2);
        if(now.match(regex))
        arr1.push(now);
    }
    for(let i=0; i<str2.length; i++){
        let now = str2.slice(i,i+2);
        if(now.match(regex))
        arr2.push(str2.slice(i,i+2));
    }
    let cnt = 0;
    let size = arr1.length + arr2.length;
    arr1.map((el) =>{
        if(arr2.includes(el)){
            cnt++;
            let index = arr2.indexOf(el);
            arr2.splice(index,1);
        }   
        return;
    })
    cnt /= (size-cnt);
    if(cnt >= 0){
        return Math.floor(cnt*65536)
    }
    else
    return 65536;
}