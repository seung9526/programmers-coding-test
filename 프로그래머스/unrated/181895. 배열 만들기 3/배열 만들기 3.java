import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals).flatMapToInt(s -> Arrays.stream(Arrays.copyOfRange(arr, s[0],s[1]+1))).toArray();
    }
}