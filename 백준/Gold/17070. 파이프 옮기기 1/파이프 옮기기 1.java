import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    
    private static int N, sum;
    private static int[][] arr;
    
    private static final int[] dr = {0, 1, 1};
    private static final int[] dc = {1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        sum = 0;
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 1, 0);
        
        System.out.println(sum);
    }
    
    public static void dfs(int r, int c, int dir) {
        if (r == N - 1 && c == N - 1) {
            sum++;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if ((dir == 0 && i == 1) || (dir == 1 && i == 0)) {
                continue;
            }
            
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
                if (i == 2 && (arr[r][c + 1] == 1 || arr[r + 1][c] == 1)) {
                    continue;
                }
                dfs(nr, nc, i);
            }
        }
    }
}