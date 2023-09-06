class Solution {
    public int solution(String binomial) {
        String[] strArr = binomial.split(" ");
        int answer = 0;
        
        if(strArr[1].equals("+")){
            answer = Integer.valueOf(strArr[0]) + Integer.valueOf(strArr[2]);
        } else if(strArr[1].equals("-")){
            answer = Integer.valueOf(strArr[0]) - Integer.valueOf(strArr[2]);
        } else if(strArr[1].equals("*")){
            answer = Integer.valueOf(strArr[0]) * Integer.valueOf(strArr[2]);
        }
        
        return answer;
    }
}