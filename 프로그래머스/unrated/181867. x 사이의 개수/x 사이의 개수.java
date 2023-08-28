class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x", myString.length());
        int[] answer = new int[strArr.length];
        
        for(int i=0; i<strArr.length;i++){
            answer[i] = strArr[i].length();
        }
        
        return answer;
    }
}