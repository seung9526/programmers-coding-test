import java.util.*;

class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String str ="";
        String result ="";
        
        Map<String, String> map = Map.of(
            "zero", "0",
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
        );
        
        for(int i=0; i<numbers.length(); i++){
            str += numbers.substring(i, i+1);
            if(map.containsKey(str)){
                result += map.get(str);
                str = "";
            }
        }
        answer = Long.parseLong(result);
        
        return answer;
    }
}