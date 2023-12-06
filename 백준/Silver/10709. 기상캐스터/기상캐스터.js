const fs = require("fs");

const input = fs.readFileSync("dev/stdin").toString().split("\n");

let [H, W] = input[0].split(" ");

H = Number(H);
W = Number(W);

const arr = new Array(H).fill(-1).map((v) => new Array(W).fill(-1));

for (let i = 1; i < input.length; i++) {
  for (let j = 0; j < input[i].length; j++) {
    if (input[i][j] == "c") {
      arr[i - 1][j] = 0;
    }
  }
}

const go = (x, y) => {
  for (let i = y + 1; i < W; i++) {
    if (arr[x][i] == 0) break;
    else arr[x][i] = arr[x][i - 1] + 1;
  }
};
for (let i = 0; i < H; i++) {
  for (let j = 0; j < W; j++) {
    if (arr[i][j] == 0) go(i, j);
  }
}
for (let i = 0; i < arr.length; i++) {
  arr[i] = arr[i].join(" ");
}
console.log(arr.join("\n"));
