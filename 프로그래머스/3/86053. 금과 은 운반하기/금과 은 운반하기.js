function solution(a, b, g, s, w, t) {
    const n = g.length;
    const maxTime = 1e16; // 충분히 큰 값
    let left = 0;
    let right = maxTime;
    let answer = maxTime;

    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        let gold = 0;
        let silver = 0;
        let total = 0;

        for (let i = 0; i < n; i++) {
            const move = Math.floor(mid / (t[i] * 2)) + (mid % (t[i] * 2) >= t[i] ? 1 : 0);
            const maxTransfer = move * w[i];

            gold += Math.min(g[i], maxTransfer);
            silver += Math.min(s[i], maxTransfer);
            total += Math.min(g[i] + s[i], maxTransfer);
        }

        if (gold >= a && silver >= b && total >= a + b) {
            answer = mid;
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return answer;
}