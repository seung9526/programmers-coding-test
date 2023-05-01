import java.util.*;

class Solution {
    public ArrayList solution(int[] numbers, String direction) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<numbers.length; i++){
            answer.add(numbers[i]);
        }

        if(direction.equals("right")){
            answer.add(0, numbers[numbers.length-1]);
            answer.remove(answer.size()-1);

        }else if(direction.equals("left")){
            answer.add(numbers[0]);
            answer.remove(0);
        }

        return answer;
    }
}