import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    
    private static int T, N, K, ans, maxHeight;
    private static int[][] map;
    private static boolean[][] visited;
    
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            
            init(); 
            
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > maxHeight) {
                        maxHeight = map[i][j];
                    }
                }
            }
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false); 
                        visited[i][j] = false; 
                    }
                }
            }
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void init() {
        map = new int[N][N];
        visited = new boolean[N][N];
        ans = 0;
        maxHeight = 0;
    }
    

    public static void dfs(int r, int c, int len, boolean isCut) {
        
        ans = Math.max(ans, len);
        
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) continue;
            
            if(map[nr][nc] < map[r][c]) {
                visited[nr][nc] = true;
                dfs(nr, nc, len + 1, isCut);
                visited[nr][nc] = false;
            } 
       
            else if(!isCut && map[nr][nc] - K < map[r][c]) {
                int originalHeight = map[nr][nc]; 
                
                visited[nr][nc] = true;
                map[nr][nc] = map[r][c] - 1; 
                
                dfs(nr, nc, len + 1, true); 
                
                map[nr][nc] = originalHeight; 
                visited[nr][nc] = false;    
            }
        }
    }
}