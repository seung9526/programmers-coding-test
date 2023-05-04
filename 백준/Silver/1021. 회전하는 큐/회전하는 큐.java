import java.util.*;

public class Main {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        int[] arr = new int[m];
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int index = ((LinkedList<Integer>) deque).indexOf(arr[i]);
            int size = deque.size();

            if (deque.peekFirst() == arr[i]) {
                deque.pollFirst();
            } else if (index <= size / 2) {
                for (int j = 0; j < index; j++) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
                deque.pollFirst();
            } else {
                for (int j = 0; j < size - index; j++) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
                deque.pollFirst();
            }
        }

        System.out.println(cnt);
    }
}
