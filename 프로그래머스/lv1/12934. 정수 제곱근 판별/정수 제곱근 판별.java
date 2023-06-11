class Solution {
    public long solution(long n) {
        double answer = Math.ceil(Math.sqrt(n));
        double res = Math.pow(answer+1, 2);
       
        if(Math.pow(answer, 2)==n){
            return (long)res;
        } 
        return -1;
    }
}