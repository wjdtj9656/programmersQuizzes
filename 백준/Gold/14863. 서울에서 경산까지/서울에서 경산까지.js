const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
const input = [];
rl.on("line", (line) => {
  input.push(line);
}).on("close", () => {
  const [N, K] = input[0].split(" ").map(Number);
  const arr1 = [];
  const arr2 = [];
  for (let i = 0; i < N; i++) {
    const [a1, a2, b1, b2] = input[i + 1].split(" ").map(Number);
    arr1.push([a1, a2]);
    arr2.push([b1, b2]);
  }
  const dp = new Array(101).fill(0).map(() => new Array(100001).fill(0));
  const go = (here, time) => {
    if (here == N) return 0;
    if (dp[here][time]) return dp[here][time];
    dp[here][time] = -Infinity;
    if (time - arr1[here][0] >= 0)
      dp[here][time] = Math.max(
        dp[here][time],
        go(here + 1, time - arr1[here][0]) + arr1[here][1]
      );
    if (time - arr2[here][0] >= 0)
      dp[here][time] = Math.max(
        dp[here][time],
        go(here + 1, time - arr2[here][0]) + arr2[here][1]
      );
    return dp[here][time];
  };
  console.log(go(0, K));
});
