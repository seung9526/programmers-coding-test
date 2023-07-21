import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int[] available = new int[3];
        int[] request = new int[3];
        
        for(int i=0;i<3;i++){
            available[i] = sc.nextInt();
        }
        for(int i=0;i<3;i++){
            request[i] = sc.nextInt();
        }
        
        int res = 0;
        
        for(int i=0; i<3; i++){
            if(request[i]-available[i] >0){
                res += (request[i]-available[i]);
            }
        }
        System.out.print(res);
    }
}