import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String strTmp = s;
        int sLength = strTmp.length();

        List<String> charList = new ArrayList<>();
        while(sLength > 0) {
            String str = strTmp.substring(0,1);
            strTmp = strTmp.replace(str, "");
            if(sLength - strTmp.length() == 1){ charList.add(str); }
            sLength = strTmp.length();
        }

        Collections.sort(charList);

        for(int i=0; i<charList.size(); i++){
            answer += charList.get(i);
        }

        return answer;
    }
}