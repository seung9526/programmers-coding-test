import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; k*i<=n; i++){
            list.add(k*i);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}