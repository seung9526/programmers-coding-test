import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        int start = 0;
        int end = 0;
        
        for(int i=0;i<query.length;i++){
            if(i%2==0){
                end=start+query[i];
            }
            else{
                start+= query[i];
            }
        }
        
        if(start>end) return new int[]{-1};
        
        return Arrays.copyOfRange(arr, start, end+1);
    }
}