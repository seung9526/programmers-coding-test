import java.util.*;

class Solution {
    public String solution(String my_string) {
        String[] answer = my_string.split("");
        Set<String> set = new LinkedHashSet(Arrays.asList(answer));
        
        return String.join("", set);
    }
}