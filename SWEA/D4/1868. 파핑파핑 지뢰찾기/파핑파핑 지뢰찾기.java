
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int N,T,cnt;


    private static char[][] map;
    private static int[][] mineCnt;
    private static boolean[][] visited;

    private static final int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    private static final int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            int cnt = 0;
            N  = Integer.parseInt(br.readLine());
            map = new char[N][N];
            mineCnt = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            countMines();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '.' && mineCnt[i][j] == 0 && !visited[i][j]) {
                        cnt++;
                        boomMine(i, j);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] == '.' && !visited[i][j]) {
                        cnt++;
                    }
                }
            }



            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void boomMine(int x, int y) {

        visited[x][y] = true;

        if(mineCnt[x][y] > 0) {
            return;
        }

        for(int i = 0; i< 8; i++){
            int nr = x + dr[i];
            int nc = y + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(map[nr][nc] == '.' && !visited[nr][nc]){
                    boomMine(nr, nc);
                }
            }

        }
    }

    public static void countMines() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*') {
                            count++;
                        }
                    }
                    mineCnt[i][j] = count;
                }
            }
        }
    }
}
