const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const n = input[0];
let result = [];
for (let i = 1; i < input.length; i++) {
  input[i] = input[i].trim();
  let str = "";
  for (let j = 0; j < input[i].length; j++) {
    if (!isNaN(Number(input[i][j]))) {
      str += input[i][j];
    } else {
      if (str.length > 0) {
        result.push(BigInt(str));
      }
      str = "";
    }
  }
  if (str.length > 0) {
    result.push(BigInt(str));
  }
}
result.sort((a, b) => (a < b ? -1 : a > b ? 1 : 0));
console.log(result.join("\n").trim());
