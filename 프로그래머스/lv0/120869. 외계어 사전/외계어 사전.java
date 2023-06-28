class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean check = false;
        
        for(String dt : dic){
            int cnt = 0;
            for(String s : spell){
                if(dt.contains(s)){
                    cnt++;
                }
            }
             if(cnt == spell.length){
                    check = true;
                    break;
            }
        }
        return check ?  1 : 2;
    }
}