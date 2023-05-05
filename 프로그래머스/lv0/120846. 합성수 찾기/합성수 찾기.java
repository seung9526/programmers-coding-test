class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=4;i<=n;i++){
            if(values(i)){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean values(int number){
        int cnt =0;
        for(int i=1; i<=Math.sqrt(number);i++){
            if(number%i==0){
                cnt++;
            }
        }
        return cnt >=2;
    }
}