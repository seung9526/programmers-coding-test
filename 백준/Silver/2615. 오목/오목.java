import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] move = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[19][19];
        StringTokenizer st;
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(arr);

    }

    public static void solution(int[][] arr) {
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 19; i++) {
                if (arr[i][j] == 1 || arr[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int x = i;
                        int y = j;
                        int cnt = 1;


                        while (true) {
                            x += move[k][0];
                            y += move[k][1];
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                if (arr[i][j] == arr[x][y]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        x = i;
                        y = j;

                        while (true) {
                            x -= move[k][0];
                            y -= move[k][1];
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                if (arr[i][j] == arr[x][y]) {
                                    cnt++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        if (cnt == 5) {
                            System.out.println(arr[i][j]);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
        return;
    }
}