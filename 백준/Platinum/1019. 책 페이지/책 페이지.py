def count_digits_upto(N):
    counts = [0] * 10
    factor = 1
    
    while factor <= N:
        # 현재 자리수 기준으로 상위, 현재, 하위 숫자 계산
        higher = N // (factor * 10)
        current = (N // factor) % 10
        lower = N % factor
        
        # 0부터 9까지 각 숫자에 대해 계산
        for d in range(10):
            if d < current:
                counts[d] += (higher + 1) * factor
            elif d == current:
                counts[d] += higher * factor + lower + 1
            else:
                counts[d] += higher * factor
        
        # 0에 대한 특별 처리: 맨 앞자리에서는 0이 올 수 없음
        counts[0] -= factor
        
        factor *= 10
    
    return counts

N = int(input())
result = count_digits_upto(N)
print(' '.join(map(str, result)))