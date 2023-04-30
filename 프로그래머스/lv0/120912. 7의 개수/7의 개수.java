class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int i=0; i<array.length; i++){
            String strNum = Integer.toString(array[i]);
            String[] strArr = strNum.split("");
        
            for(int j=0; j<strArr.length;j++){
                if(strArr[j].equals("7")){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}