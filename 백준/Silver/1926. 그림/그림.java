import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] canvas;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxArea = 0;
    static int pictureCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        canvas = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (canvas[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                    pictureCount++;
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maxArea);
        br.close();
    }


    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;  

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (canvas[nx][ny] == 1 && !visited[nx][ny]) {
                    area += dfs(nx, ny);
                }
            }
        }

        return area;
    }
}
