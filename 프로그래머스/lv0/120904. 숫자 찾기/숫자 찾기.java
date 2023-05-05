class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String[] str = String.valueOf(num).split("");
        
        for(int i=0;i<str.length;i++){
            if(str[i].equals(String.valueOf(k))){
                answer = i+1;
                break;
            } else {
                answer= -1;
            }
        }
        return answer;
    }
}