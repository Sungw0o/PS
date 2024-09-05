import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int normalCnt = 0;
    static int colorBlindCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    normalCnt++;
                    dfs(i, j, false);
                }
            }
        }
        
        clearVisited();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorBlindCnt++;
                    dfs(i, j, true);
                }
            }
        }

        System.out.println(normalCnt + " " + colorBlindCnt);
        br.close();
    }

    public static void dfs(int x, int y, boolean isColorBlind) {
        visited[x][y] = true;
        char currentColor = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (isColorBlind && (currentColor == 'R' || currentColor == 'G')) {
                    if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                        dfs(nx, ny, isColorBlind);
                    }
                } else if (map[nx][ny] == currentColor) {
                    dfs(nx, ny, isColorBlind);
                }
            }
        }
    }

    public static void clearVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }
    }
}
