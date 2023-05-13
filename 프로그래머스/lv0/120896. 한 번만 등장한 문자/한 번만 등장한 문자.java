import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] array=s.toCharArray();
        int count=0;
        
        Arrays.sort(array);//a..z순으로 정렬
        
        s=String.valueOf(array);
        
        for(int i=0;i<s.length();i++){
            if(i==s.length()-1){
                if(count==0){
                    answer=answer+s.charAt(i);
                }
                else{
                    break;
                }
            }
            else if(s.charAt(i)==s.charAt(i+1)){//뒤랑 같으면
                count++;
            }
            else{//다르면
                if(count>0){//근데 이전까지 같은애가 있었다.
                    count=0;
                    continue;
                }
                else{//같은 애도 없었고, 혼자다
                    answer=answer+s.charAt(i);
                }
            }
        }
        
        
        return answer;
    }
}