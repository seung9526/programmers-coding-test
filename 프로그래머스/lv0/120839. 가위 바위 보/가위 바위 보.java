class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder("");
        char[] ch = rsp.toCharArray();
        
        for(int i=0;i<ch.length;i++){
            switch(ch[i]){
                case '2':
                    answer.append("0");
                    break;
                case '0':
                    answer.append("5");
                    break;
                case '5':
                    answer.append("2");
                    break;
            }
        }
        return answer.toString();
    }
}