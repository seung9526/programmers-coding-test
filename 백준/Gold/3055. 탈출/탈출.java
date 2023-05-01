import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static char[][] map;
    static Queue<Integer> water;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new char[n][m];
        water = new LinkedList<>();
        int S = 0;
        int D = 0;
        for(int i=0; i < n; i++){
            String s = br.readLine();
            for(int j=0; j < m; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == '*'){
                    water.offer(i * m + j);
                }
                if(map[i][j] == 'S'){
                    S = i*m + j;
                } else if(map[i][j] == 'D'){
                    D = i*m + j;
                }
            }
        }
        int ans = bfs(S, D);
        
        // 도달할 수 없다면 -1이 반환된다.
        System.out.println(ans == -1 ? "KAKTUS" : ans);
        
        br.close();
    }
    
    private static int bfs(int S, int D){
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        int y = S / m; int x = S % m;
        q.offer(new Pos(y, x, 0));
        visited[y][x] = true;
        
        while(!q.isEmpty()){
        
            // 먼저 물 부터 이동 시킨다.
            int w = water.size();
            for(int i=0; i < w; i++){
                int num = water.poll();
                int wy = num / m;
                int wx = num % m;
                
                for(int j=0; j < 4; j++){
                    int ny = wy + dy[j];
                    int nx = wx + dx[j];
                    
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if(map[ny][nx] == '.'){
                        map[ny][nx] = '*';
                        water.offer(ny * m + nx);
                    }
                }
            }
            
            // 현재 기준 모든 이동 가능한 곳으로 고슴도치를 이동
            int size = q.size();
            for(int i=0; i < size; i++){
                Pos p = q.poll();
                int sy = p.y;
                int sx = p.x;
                
                for(int j=0; j < 4; j++){
                    int ny = sy + dy[j];
                    int nx = sx + dx[j];
                    
                    // 범위를 벗어났거나 이미 방문했거나 돌 또는 물의 위치면 이동할 수 없다.
                    if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if(visited[ny][nx] || map[ny][nx] == '*' || map[ny][nx] == 'X') continue;
                    
                    // 비버의 굴로 이동했을 경우
                    if(map[ny][nx] == 'D'){
                        return p.move + 1;
                    // 빈 공간으로 이동했을 경우
                    } else {
                       visited[ny][nx] = true;
                       q.offer(new Pos(ny, nx, p.move+1));
                    }
                }
            }
        }
        return -1;
    }
}

class Pos{
    int y;
    int x;
    int move;
    public Pos(int y, int x, int move){
        this.y=y;
        this.x=x;
        this.move=move;
    }
}