import sys

def solve():
    min_val, max_val = map(int, sys.stdin.readline().split())
    
    # min부터 max까지의 수를 나타내는 불리언 배열. True는 제곱ㄴㄴ수 후보.
    is_square_free = [True] * (max_val - min_val + 1)
    
    # 2부터 sqrt(max_val)까지의 모든 제곱수를 확인
    i = 2
    while i * i <= max_val:
        square = i * i
        
        # min_val보다 크거나 같은 첫 번째 제곱수의 배수 찾기
        start_num = (min_val + square - 1) // square * square
        
        # start_num부터 max_val까지 제곱수의 배수들을 제거
        for j in range(start_num, max_val + 1, square):
            is_square_free[j - min_val] = False
            
        i += 1
    
    # 제거되지 않은 수(True)의 개수 세기
    count = 0
    for is_free in is_square_free:
        if is_free:
            count += 1
            
    print(count)

if __name__ == "__main__":
    solve()