import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String[] str = a.split("");
        String answer = "";
        
        for (String s : str){
            if(Character.isUpperCase(s.charAt(0))){
                answer += s.toLowerCase();
            } else {
                answer += s.toUpperCase();
            }
        }
        
        
        System.out.print(answer);        
    }
}