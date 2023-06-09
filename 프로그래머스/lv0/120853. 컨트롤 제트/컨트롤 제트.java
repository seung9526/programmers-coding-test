import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (String str : s.split(" ")){
            if(str.equals("Z")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        for(int i : stack){
           answer += i;
        }
        return answer;
        /*
        String[] sArr = s.split(" ");
        int answer = 0;
        
        for(int i=0; i<sArr.length; i++){
            if(sArr[i].equals("Z")){
                answer-= Integer.parseInt(sArr[i - 1]);
                continue;
            }
            answer += Integer.parseInt(sArr[i]);
        }
        
        return answer;
        */
    }
}