class Solution {
    public int solution(int a, int b) {
        String res1 = Integer.toString(a)+Integer.toString(b);
        String res2 = Integer.toString(b)+Integer.toString(a);
        
        if(Integer.parseInt(res1)>Integer.parseInt(res2)){
            return Integer.parseInt(res1);
        } else {
        return Integer.parseInt(res2);
        }
    }
}