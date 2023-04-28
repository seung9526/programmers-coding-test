class Solution {
    public int solution(int[] box, int n) {
        int answer, w, h, d = 0;
        
        w=box[0]/n;
        h=box[1]/n;
        d=box[2]/n;
        
        answer = w*h*d;
        
        return answer;
    }
}