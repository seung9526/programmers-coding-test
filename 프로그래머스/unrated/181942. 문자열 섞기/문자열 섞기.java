import java.util.*;

class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        
        String[] str1Arr = str1.split("");
        String[] str2Arr = str2.split("");
        
        for (int i=0; i < str1.length(); i++) {
            answer += str1Arr[i]+str2Arr[i];
        }

        return answer.toString();
    }
}