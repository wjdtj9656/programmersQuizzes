function solution(sales, links) {
    const n = sales.length;
    const tree = {};
    
    for(let [a,b] of links){
        if(!tree[a]) tree[a] = [];
        tree[a].push(b);
    }
    
    const dp = new Array(n+1).fill(0).map(()=>new Array(2).fill(0));
    
    const dfs = (node) =>{
        if(!tree[node] || tree[node].length === 0){
            dp[node][0] = 0;
            dp[node][1] = sales[node-1];
            return;
        }
        let nAttend = 0;
        let attend = sales[node-1];
        
        let fee = Infinity;
        
        for(const child of tree[node]){
            dfs(child);
            
            attend += Math.min(dp[child][0], dp[child][1]);
            
            if(dp[child][0] < dp[child][1]){
                nAttend += dp[child][0];
                fee = Math.min(fee, dp[child][1] - dp[child][0]);
            }else{
                nAttend += dp[child][1];
                fee = 0;
            }
        }
        dp[node][1] = attend;
        if(fee !== 0 && fee !== Infinity){
            dp[node][0] = nAttend + fee;
        }else{
            dp[node][0] = nAttend;
        }
    }
    dfs(1);
    return Math.min(dp[1][0], dp[1][1]);
}