class Solution {
    public int[] solution(int denum1, int numon1, int denum2, int numon2) {
        int[] answer = new int[2]; 
        
        int num1 = numon1*numon2; //분모
        int num2 = denum1*numon2+denum2*numon1; //분자
        int max = 1;  
        
        //최대 공약수
        for(int i=1; i <= num1 && i<= num2; i++){     
            if(num1%i==0 && num2%i==0){
                max = i;
            }
        }
        answer[0] = num2/max; 
        answer[1] = num1/max; 
        
        return answer;
    }
}