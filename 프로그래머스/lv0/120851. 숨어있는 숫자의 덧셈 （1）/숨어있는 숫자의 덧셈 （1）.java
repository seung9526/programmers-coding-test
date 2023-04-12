import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String str = my_string.replaceAll("[^0-9]","");
		for (char ch : str.toCharArray()){
            answer+= Character.getNumericValue(ch);
        }
		return answer;

    }
}