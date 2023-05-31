class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String str1 = myString.toUpperCase();
        String str2 = pat.toUpperCase();
        
        if(str1.contains(str2)){
            return 1;
        }
        return 0;
    }
}