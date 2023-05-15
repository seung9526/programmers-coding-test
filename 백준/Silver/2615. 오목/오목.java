import java.util.*;

public class Main {
	static int N, n, answer, x, y;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = 19;
		n = 5;
		answer = 0;
		x = Integer.MAX_VALUE;
		y = Integer.MAX_VALUE;
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		Here: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				// 돌이 없는 칸은 검사할 필요가 없습니다.
				if (board[i][j] == 0) continue;
				
				// 가로로 오목인지 확인합니다.
				if (j + n <= N) {
					// 5개의 숫자가 연속해야 five가 true로 유지됩니다.
					boolean five = true;
					for (int k = 0; k < n; k++) {
						if (board[i][j] == board[i][j + k]) continue;
						five = false;
						break;
					}
					
					// 현재 판에 1이 있는지 2가 있는지를 확인합니다.
					int player = board[i][j];
					
					// 5개의 돌이 동일하고, 왼쪽 혹은 오른쪽에 동일한 돌이 없다면 정답입니다.
					if (five && row_edge_test(i, j, player)) {
						answer = player;
						x = i;
						y = j;
						break Here;
					}
				}
				
				// 세로로 오목인지 확인합니다.
				if (i + n <= N) {
					boolean five = true;
					for (int k = 0; k < n; k++) {
						if (board[i][j] == board[i + k][j]) continue;
						five = false;
						break;
					}
					int player = board[i][j];
					if (five && col_edge_test(i, j, player)) {
						answer = player;
						x = i;
						y = j;
						break Here;
					}
				}
				
				// 오른쪽아래 대각선으로 오목인지 확인합니다.
				if (i + n <= N && j + n <= N) {
					boolean five = true;
					for (int k = 0; k < n; k++) {
						if (board[i][j] == board[i + k][j + k]) continue;
						five = false;
						break;
					}
					int player = board[i][j];
					if (five && rd_edge_test(i, j, player)) {
						answer = player;
						x = i;
						y = j;
						break Here;
					}

				}
				
				// 오른쪽위 대각선으로 오목인지 확인합니다.
				if (i +1 - n >= 0 && j + n <= N) {
					boolean five = true;
					for (int k = 0; k < n; k++) {
						if (board[i][j] == board[i - k][j + k]) continue;
						five = false;
						break;
					}
					int player = board[i][j];
					if (five && ru_edge_test(i, j, player)) {
						answer = player;
						x = i;
						y = j;
						break Here;
					}

				}
			}

		}

		System.out.println(answer);
		if(answer != 0) {
			System.out.println((x + 1) + " " + (y + 1));			
		}

	}

	public static boolean row_edge_test(int x, int y, int player) {
		boolean left_flag = false;
		boolean right_flag = false;
		// 왼쪽을 검사할 수 없거나, 왼쪽돌이 오목의 돌과 다른색이면 왼쪽검사 통과
		if (y - 1 < 0 || (board[x][y - 1] != player)) left_flag = true;
		// 오른쪽을 검사할 수 없거나, 오른쪽돌이 오목의 돌과 다른 색이면 오른쪽 검사 통과
		if (y + n >= N || (y + n < N && board[x][y + n] != player)) right_flag = true;
		// 오른쪽검사와 왼쪽검사를 모두 통과해야 승리
		return left_flag & right_flag;
	}

	public static boolean col_edge_test(int x, int y, int player) {
		boolean left_flag = false;
		boolean right_flag = false;
		if (x - 1 < 0 || (board[x - 1][y] != player)) left_flag = true;
		if (x + n >= N || (x + n < N && board[x + n][y] != player)) right_flag = true;
		return left_flag & right_flag;
	}

	public static boolean rd_edge_test(int x, int y, int player) {
		boolean left_flag = false;
		boolean right_flag = false;
		if (x - 1 < 0 || y - 1 < 0 || board[x - 1][y - 1] != player) left_flag = true;
		if (x + n >= N || y + n >= N || board[x + n][y + n] != player) right_flag = true;
		return left_flag & right_flag;
	}

	public static boolean ru_edge_test(int x, int y, int player) {
		boolean left_flag = false;
		boolean right_flag = false;
		if (x + 1 >= N || y - 1 < 0 || board[x + 1][y - 1] != player) left_flag = true;
		if (x - n < 0 || y + n >= N || board[x - n][y + n] != player) right_flag = true;
		return left_flag & right_flag;
	}

}