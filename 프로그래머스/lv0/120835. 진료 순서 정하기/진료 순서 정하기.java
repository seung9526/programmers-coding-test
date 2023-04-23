import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] res = Arrays.copyOf(emergency, emergency.length);
        
        Arrays.sort(res);
        
        for(int i=0;i<emergency.length;i++){
            for(int j=0;j<res.length;j++){
                if(emergency[i]==res[j]){
                    answer[i]=emergency.length - j;
                }
                
            }
        }
        
        return answer;
    }
}