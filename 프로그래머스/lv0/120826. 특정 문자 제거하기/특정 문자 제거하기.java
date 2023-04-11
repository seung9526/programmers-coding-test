class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        
        for(char ch : letter.toCharArray()){
            answer = my_string.replace(String.valueOf(ch), "");
        }
        
        return answer;
    }
}