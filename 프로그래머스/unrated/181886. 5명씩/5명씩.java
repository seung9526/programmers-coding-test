import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> answer = new ArrayList();
        for(int i=0, j=0; i<names.length; i+= 5, j++) {
            answer.add(names[i]);
            }
        
        String[] str = answer.toArray(new String[0]);
        return str;
    }
}