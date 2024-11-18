function solution(N, stages) {
    let stageCounts = Array(N + 1).fill(0);
    stages.forEach(stage => {
        if (stage <= N) {
            stageCounts[stage]++;
        }
    });
    
    let total = stages.length;
    let failRate = [];
    
    for(let i = 1; i <= N; i++) {
        if(total === 0) {
            failRate.push([i, 0]);
        } else {
            failRate.push([i, stageCounts[i] / total]);
            total -= stageCounts[i];
        }
    }
    
    failRate.sort((a, b)  => b[1] - a[1] || a[0] - b[0]);
    
    return failRate.map(rate => rate[0]);
}
