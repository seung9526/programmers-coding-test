import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strNum = new String[numbers.length];
        
        for(int i=0; i<strNum.length; i++){
            strNum[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(strNum, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        
        for(String tmp : strNum){
            answer+=tmp;
        }

        if(answer.startsWith("0")){
           answer="0";
        }
        
        return answer.toString();
    }
}