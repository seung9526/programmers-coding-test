N=int(input())
card_price = list(map(int, input().split()))

max_price = [0] * (N+1)

for i in range(1, N + 1):
    for k in range(i, 0, -1): 
         max_price[i] = max(max_price[i], max_price[i - k] + card_price[k - 1])

print(max_price[N])