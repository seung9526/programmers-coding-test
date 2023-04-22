class Solution {
    public int solution(int hp) {
        int answer = 0;
        
        int[] ant = {5,3,1};
        
        for(int an : ant){
            answer += hp/an;
            hp%=an;
        }
        
        return answer;
    }
}