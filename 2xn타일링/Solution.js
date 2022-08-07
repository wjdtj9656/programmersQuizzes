function solution(n) {
    let arr = [];
    arr.push(1);
    arr.push(2);
    for(let i=2; i<n; i++){
        arr.push((arr[arr.length-1] + arr[arr.length-2])%1000000007);
    }
    
    return arr[n-1]%1000000007;
}