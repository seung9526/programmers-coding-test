import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
    /* 차량번호 6-8
    *  영어 A-Z, 숫자 0-9
    *  입력 2N+1, 첫줄 N 차의 대수
    *  두번째 줄 N 개의 차량번호 목록
    * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> carList = new HashMap<>();

        for(int i=0;i<n;i++){
            String carName = br.readLine();
            carList.put(carName, i);
        }

        int cnt =0;
        boolean[] inOut = new boolean[n];

        for(int i=0;i<n;i++){
            String carName = br.readLine();
            int num = carList.get(carName);

            for(int j=0;j<num;j++){
                if(!inOut[j]){
                    cnt++;
                    break;
                }
            }
            inOut[num]=true;
        }
        System.out.println(cnt);
        br.close();
    }
}
