class Solution {
    public boolean solution(int x) {
        
        String [] strArr = String.valueOf(x).split("");
        int sum=0;
        for(String s:strArr) {
            sum+=Integer.parseInt(s);
        }

        if(x%sum==0) {
            return true;
        } else {
            return false;
        }
    }
}

