import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    private static int T, N;
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static int[][] cheeze;
    private static boolean[][] visited;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            cheeze = new int[N][N];
            int maxDay = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cheeze[i][j] = Integer.parseInt(st.nextToken());
                    maxDay = Math.max(maxDay, cheeze[i][j]); 
                }
            }

            int maxChunks = 1; 

            for (int day = 1; day <= maxDay; day++) {
                visited = new boolean[N][N];
                int currentChunks = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (cheeze[i][j] > day && !visited[i][j]) {
                            dfs(i, j, day);
                            currentChunks++;
                        }
                    }
                }
                maxChunks = Math.max(maxChunks, currentChunks);
            }

            System.out.println("#" + t + " " + maxChunks);
        }
    }

    public static void dfs(int r, int c, int day) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (rangeCheck(nr, nc) && !visited[nr][nc] && cheeze[nr][nc] > day) {
                dfs(nr, nc, day);
            }
        }
    }

    public static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}