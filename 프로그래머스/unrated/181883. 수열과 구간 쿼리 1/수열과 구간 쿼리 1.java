class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] que : queries){
            int str = que[0];
            int end = que[1];
            
            for(int i=str; i<=end; i++){
                arr[i]+=1;
            }
        }
        return arr;
    }
}