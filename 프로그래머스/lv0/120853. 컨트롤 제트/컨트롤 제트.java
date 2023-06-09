class Solution {
    public int solution(String s) {
        String[] sArr = s.split(" ");
        int answer = 0;
        
        for(int i=0; i<sArr.length; i++){
            if(sArr[i].equals("Z")){
                answer-= Integer.parseInt(sArr[i - 1]);
                continue;
            }
            answer += Integer.parseInt(sArr[i]);
        }
        
        return answer;
    }
}