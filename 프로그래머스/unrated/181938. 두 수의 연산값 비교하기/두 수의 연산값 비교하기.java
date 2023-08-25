class Solution {
    public int solution(int a, int b) {
        
        String ab = Integer.toString(a)+Integer.toString(b);
        int iab = Integer.parseInt(ab);
        
        if(iab>= 2*a*b){
            return iab;
        } else {
            return 2*a*b;
        }
    }
}