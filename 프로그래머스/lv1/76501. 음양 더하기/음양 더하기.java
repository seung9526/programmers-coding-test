class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            // 3항 연산자 통해 1또는 -1을 곱해주어 결과 값 출력
            answer += absolutes[i] * (signs[i] ? 1 : -1);
            /*
            if(signs[i] == true){
                answer += absolutes[i];
            } else if(signs[i] == false){
                answer -= absolutes[i];
            }
            */
        }
        
        return answer;
    }
}