def solution(n):
    MOD = 1000000007
    dp = [0] * (max(n, 6) + 1)
    dp[0] = 1
    dp[1] = 1
    dp[2] = 3
    dp[3] = 10
    dp[4] = 23
    dp[5] = 62
    dp[6] = 170
    
    for i in range(7, n + 1):
        dp[i] = (dp[i-1] + 2*dp[i-2] + 6*dp[i-3] + dp[i-4] - dp[i-6]) % MOD
    
    return dp[n]