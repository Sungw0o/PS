import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int N, M, sum;
    private static int[][] map;
    private static boolean[][] visited;
    
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new boolean[N][M]; 
        sum = 0;
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true; 
                dfs(i, j, map[i][j], 1); 
                visited[i][j] = false; 
            }
        }
        
        System.out.println(sum);
        br.close();
    }
    
    public static void dfs(int r, int c, int currentSum, int depth) {
        if (depth == 4) {
            sum = Math.max(sum, currentSum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
                continue;
            }
            
            if (depth == 2) {
                visited[nr][nc] = true;
                dfs(r, c, currentSum + map[nr][nc], depth + 1);
                visited[nr][nc] = false;
            }
            
            visited[nr][nc] = true;
            dfs(nr, nc, currentSum + map[nr][nc], depth + 1); 
            visited[nr][nc] = false;
        }
    }
}