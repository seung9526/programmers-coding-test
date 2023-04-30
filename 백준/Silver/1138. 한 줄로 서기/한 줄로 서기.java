import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] line = new int[n];

        for (int i = 0; i < n; i++) {
            int taller = sc.nextInt();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (count == taller && line[j] == 0) {
                    line[j] = i + 1;
                    break;
                } else if (line[j] == 0) {
                    count++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(line[i] + " ");
        }
    }
}
