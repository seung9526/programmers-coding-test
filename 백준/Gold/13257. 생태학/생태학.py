import sys
from math import comb

def solve():
    input = sys.stdin.readline
    N, C, D, M = map(int, input().split())
    # 안전하게 C는 N보다 클 수 없으니 제한
    C = min(C, N)

    # dp[k] = 확률(현재 태그된 마리 수가 k)
    dp = [0.0] * (N + 1)
    dp[0] = 1.0

    total_choose = comb(N, C)  # 하루에 C마리 뽑는 경우의 수

    for _ in range(D):
        ndp = [0.0] * (N + 1)
        for k in range(N + 1):
            if dp[k] == 0.0:
                continue
            untagged = N - k
            # 하루에 새로 태그되는 수 j의 범위
            minj = max(0, C - k)
            maxj = min(C, untagged)
            for j in range(minj, maxj + 1):
                ways = comb(untagged, j) * comb(k, C - j)
                prob = ways / total_choose
                ndp[k + j] += dp[k] * prob
        dp = ndp

    print("{:.16f}".format(dp[M]))

if __name__ == "__main__":
    solve()
