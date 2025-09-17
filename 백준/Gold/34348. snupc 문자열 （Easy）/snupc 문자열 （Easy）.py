import sys
import bisect

def main():
    data = sys.stdin.read().split()
    S = data[0]
    n = len(S)
    Q = int(data[1])
    
    # 각 문자별 위치 리스트 생성
    s_pos = []
    n_pos = []
    u_pos = []
    p_pos = []
    c_pos = []
    
    for i, char in enumerate(S):
        if char == 's':
            s_pos.append(i)
        elif char == 'n':
            n_pos.append(i)
        elif char == 'u':
            u_pos.append(i)
        elif char == 'p':
            p_pos.append(i)
        elif char == 'c':
            c_pos.append(i)
    
    # 각 쿼리 처리
    results = []
    index = 2
    for _ in range(Q):
        l = int(data[index]) - 1
        r = int(data[index + 1]) - 1
        index += 2
        
        # 이분 탐색으로 최대 k 찾기
        low, high = 0, min(
            len(s_pos), len(n_pos), len(u_pos), len(p_pos), len(c_pos),
            (r - l + 1) // 5
        )
        best_k = 0
        
        while low <= high:
            mid = (low + high) // 2
            if mid == 0:
                best_k = 0
                low = mid + 1
                continue
                
            # s k개 찾기
            s_start = bisect.bisect_left(s_pos, l)
            if s_start + mid - 1 >= len(s_pos) or s_pos[s_start + mid - 1] > r:
                high = mid - 1
                continue
            last_pos = s_pos[s_start + mid - 1]
            
            # n k개 찾기 (s 이후)
            n_start = bisect.bisect_left(n_pos, last_pos + 1)
            if n_start + mid - 1 >= len(n_pos) or n_pos[n_start + mid - 1] > r:
                high = mid - 1
                continue
            last_pos = n_pos[n_start + mid - 1]
            
            # u k개 찾기 (n 이후)
            u_start = bisect.bisect_left(u_pos, last_pos + 1)
            if u_start + mid - 1 >= len(u_pos) or u_pos[u_start + mid - 1] > r:
                high = mid - 1
                continue
            last_pos = u_pos[u_start + mid - 1]
            
            # p k개 찾기 (u 이후)
            p_start = bisect.bisect_left(p_pos, last_pos + 1)
            if p_start + mid - 1 >= len(p_pos) or p_pos[p_start + mid - 1] > r:
                high = mid - 1
                continue
            last_pos = p_pos[p_start + mid - 1]
            
            # c k개 찾기 (p 이후)
            c_start = bisect.bisect_left(c_pos, last_pos + 1)
            if c_start + mid - 1 >= len(c_pos) or c_pos[c_start + mid - 1] > r:
                high = mid - 1
                continue
            
            # 모든 문자를 k개씩 찾을 수 있음
            best_k = mid
            low = mid + 1
        
        results.append(str(best_k))
    
    sys.stdout.write("\n".join(results))

if __name__ == "__main__":
    main()