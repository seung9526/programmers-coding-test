import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M; // 세로 N, 가로 M
	static int[][] board;
	static boolean[][] mainVisited;
	static boolean[][] visited;
	static int max = -1;
	static final int size = 4;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로 사이즈 입력
		M = Integer.parseInt(st.nextToken()); // 가로 사이즈 입력
		board = new int[N][M]; // 격자판 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true; // 방문처리
				dfs(i, j, 1, board[i][j]); // 해당 좌표에서 
				visited[i][j] = false; // 방문처리
			}
		}
		System.out.println(max);
	}

	private static void dfs(int i, int j, int c, int v) { // x, y좌표, 테트로미노 개수, 계산값
		// 가지치기 : 앞으로 최대값만 발생해도 현재 max값을 넘지 못한다면 하지마라
		if((v + 1000 *(size - c)) < max) return;
		
		// 기저 조건
		if(c == 4) { // 테트로미노 완성
			max = max < v ? v : max;
			return;
		}
		
		//실행
		int nx, ny, nx2, ny2;
		for(int d = 0; d < 4; d++) {
			nx = i + dr[d];
			ny = j + dc[d];
			// 범위 체크
			if(nx < 0 || nx >= N) continue;
			if(ny < 0 || ny >= M) continue;
			// 방문 체크
			if(visited[nx][ny]) continue;
			visited[nx][ny] = true;
			// x, y좌표, 테트로미노 개수, 계산값
			dfs(nx, ny, c+1, v+board[nx][ny]);
			visited[nx][ny] = false;
		}
		if(c == 2) { // ㅗ 모양을 처리해준다
			for(int d = 0; d < 4; d++) {
				nx = i + dr[d];
				ny = j + dc[d];
				nx2 = i + dr[(d+1)%4];
				ny2 = j + dc[(d+1)%4];
				// 범위 체크
				if(nx < 0 || nx >= N) continue;
				if(ny < 0 || ny >= M) continue;
				// 범위 체크
				if(nx2 < 0 || nx2 >= N) continue;
				if(ny2 < 0 || ny2 >= M) continue;
				// 방문 체크
				if(visited[nx][ny] || visited[nx2][ny2]) continue;
				visited[nx][ny] = true;
				visited[nx2][ny2] = true;
				// x, y좌표, 테트로미노 개수, 계산값
				dfs(nx, ny, c+2, v+board[nx][ny]+board[nx2][ny2]);
				visited[nx][ny] = false;
				visited[nx2][ny2] = false;
			}
		}
	}
}