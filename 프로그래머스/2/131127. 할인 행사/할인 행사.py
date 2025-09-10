from collections import Counter

def solution(want, number, discount):
    want_dict = {w: n for w, n in zip(want, number)}
    
    result = 0
    
    for i in range(len(discount) - 9):  
        window = discount[i:i+10]
        window_count = Counter(window)
        
        if window_count == want_dict:
            result += 1
    
    return result