class Solution {
    public int solution(int num, int n) {
        int answer = 0;
        
        for(int i=2;i<=num;i++){
            if(num%n == 0){
                return 1;
            } else {
                return 0;
            }
        }
        
        return answer;
    }
}