import sys
from bisect import bisect_left
input = sys.stdin.read

def main():
    data = input().split()
    S = data[0]
    n = len(S)
    Q = int(data[1])
    
    chars = 'snupc'
    pos = {c: [] for c in chars}

    # 각 문자별 위치 기록
    for i, ch in enumerate(S):
        if ch in pos:
            pos[ch].append(i)
    
    res = []
    idx = 2
    for _ in range(Q):
        l = int(data[idx]) - 1
        r = int(data[idx+1]) - 1
        idx += 2
        
        # 최대 k 계산
        max_k = min((r-l+1)//5, *(len(pos[c]) for c in chars))
        lo, hi, best = 0, max_k, 0

        while lo <= hi:
            mid = (lo + hi) // 2
            if mid == 0:
                best = 0
                lo = 1
                continue

            cur = l
            ok = True
            for c in chars:
                arr = pos[c]
                i = bisect_left(arr, cur)
                tgt = i + mid - 1
                if tgt >= len(arr) or arr[tgt] > r:
                    ok = False
                    break
                cur = arr[tgt] + 1
            if ok:
                best = mid
                lo = mid + 1
            else:
                hi = mid - 1
        res.append(str(best))
    
    sys.stdout.write('\n'.join(res))

if __name__ == "__main__":
    main()
