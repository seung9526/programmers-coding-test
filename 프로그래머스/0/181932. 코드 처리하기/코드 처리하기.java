class Solution {
    public String solution(String code) {
        StringBuilder ret = new StringBuilder();
        int mode = 0;

        for (int idx = 0; idx < code.length(); idx++) {
            char ch = code.charAt(idx);
            if (ch == '1') {
                mode = 1 - mode; // mode 전환
            } else if (mode == 0 && idx % 2 == 0) {
                ret.append(ch); // mode 0일 때 짝수 인덱스 추가
            } else if (mode == 1 && idx % 2 == 1) {
                ret.append(ch); // mode 1일 때 홀수 인덱스 추가
            }
        }
        
        return ret.length() == 0 ? "EMPTY" : ret.toString();
    }
}