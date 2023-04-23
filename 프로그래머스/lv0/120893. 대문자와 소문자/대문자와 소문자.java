class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] chr = my_string.toCharArray();
        
        String tmp = "";
        
        for(int i=0;i<chr.length;i++)
        {
            if(chr[i]  >= 97 && chr[i] <= 122){
                tmp=chr[i]+"";
                answer+=tmp.toUpperCase();
            } else if(chr[i]>=65 && chr[i] <=90){
                tmp=chr[i]+"";
                answer+=tmp.toLowerCase();
            }
        }
        
        return answer;
    }
}