import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(num_list);
        
        for(int i=5; i<num_list.length; i++){
            list.add(num_list[i]);
        }
        
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}