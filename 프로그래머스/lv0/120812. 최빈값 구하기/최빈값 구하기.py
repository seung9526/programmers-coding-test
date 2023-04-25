from collections import Counter

def solution(array):
    count = list(dict(Counter(array)).items())
    count.sort(key=lambda x : x[1], reverse=True)
    if len(count) >= 2 and count[0][1] == count[1][1]:
        return -1
    return count[0][0]