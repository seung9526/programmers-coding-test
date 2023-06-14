import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int[] answer ={}; 
        
        List<Integer> list = new ArrayList<>();
        
        // list에 저장 = 배열의 값이 divisor로 나누어지면
        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0){
                list.add(arr[i]);
            }
        }
        // list가 나누어 떨어지지 않으면 index가 0이여서 -1 저장
        if(list.size()==0){
            list.add(-1);
        }
        
        // list의 크기 만큼 저장
        answer = new int[list.size()];
        
        // list의 값 answer에 복사
        for(int i=0;i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        // 정렬
        Arrays.sort(answer);
        
        return answer;
        
        /*
        int[] answer1= Arrays.stream(arr).filter(test -> test%divisor==0).toArray();
        Arrays.sort(answer1);
        
        if(answer1.length==0){
            answer1 = new int[] {-1};
        }
        
        return answer1;
        
        */
    }
}