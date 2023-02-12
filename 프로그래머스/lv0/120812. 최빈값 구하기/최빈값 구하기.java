import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int max=0;
        
        Arrays.sort(array);
        max = array[array.length -1];
        
        int cnt[] = new int[max+1];
        
        for(int i=0; i<array.length;i++){
            cnt[array[i]]++;
        }
        
        max = cnt[0];
        
        for(int i=1;i<cnt.length;i++){
            if(max<cnt[i]){
                max = cnt[i];
                answer=i;
            } else if(max==cnt[i]){
                answer=-1;
            }
        }
        
        return answer;
    }
}