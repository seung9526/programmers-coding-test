import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
       
        while (names.length > 0) {
            int groupSize = Math.min(5, names.length);
            String[] group = Arrays.copyOfRange(names, 0, groupSize);
                
                list.add(group[0]);
                names = Arrays.copyOfRange(names, groupSize, names.length);
        }

        String[] answer = list.toArray(new String[0]);
        
        return answer;
    }
}