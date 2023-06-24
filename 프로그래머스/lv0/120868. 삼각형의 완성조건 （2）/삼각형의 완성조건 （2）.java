import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        
        int max = sides[1];
        int min = sides[0];
        
        int lrange = max - min;
        int hrange = max + min;
        
        answer = hrange - lrange -1;
        
        return answer;
    }
}