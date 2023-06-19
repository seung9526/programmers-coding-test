class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = my_string.indexOf(is_prefix);
        // if(my_string.startsWith(is_prefix)){
        //     answer = 1;
        // }
        return answer == 0 ? 1: 0;
    }
}