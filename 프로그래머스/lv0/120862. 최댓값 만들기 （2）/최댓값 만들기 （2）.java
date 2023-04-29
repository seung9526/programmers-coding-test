import java.util.*;

class Solution {
    public int solution(int[] n) {
        
        Arrays.sort(n);
        
        int minus = n[0] * n[1];
        int max = n[n.length-1] * n[n.length-2];
        
        return minus>max ? minus : max;
        
    }
}