function solution(N, stages) {
    const result = [];
    let totalPlayers = stages.length;

    for (let stage = 1; stage <= N; stage++) {
        const notCleared = stages.filter(playerStage => playerStage === stage).length;

        const failRate = totalPlayers === 0 ? 0 : notCleared / totalPlayers;

        result.push([stage, failRate]);
        totalPlayers -= notCleared;
    }

    result.sort((a, b) => b[1] - a[1] || a[0] - b[0]);

    return result.map(([stage, _]) => stage);
}