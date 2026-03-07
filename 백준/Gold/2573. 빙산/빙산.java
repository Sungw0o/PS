import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N,M,year;

    private static final int[] dr = {-1,1,0,0};
    private static final int[] dc = {0,0,-1,1};

    private static int[][] map;
    private static int[][] meltAmount;

    private static Queue<int []> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        meltAmount = new int[N][M];
        year = 0;

        for(int i= 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j= 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1){
                    q.add(new int[]{i,j});
                    meltAmount[i][j] = map[i][j];
                }
            }
        }

        while(true){
            int pieces = countIceberg();

            if(pieces >= 2){
                sb.append(year);
                break;
            }

            if(pieces== 0){
                sb.append(0);
                break;
            }

            melt();
            year++;
        }

        System.out.println(sb);
        br.close();

    }
    // 동시 녹음 해결 -> 내가 방금 녹여서 0이 된 바닷물이 옆에 멀쩡한 빙산에 영향을 줌
    // 1년마다 **동시에** 녹여야 한다.
    public static void melt() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                            if (map[nr][nc] == 0) {
                                seaCount++;
                            }
                        }
                    }
                    meltAmount[i][j] = seaCount;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    map[i][j] -= meltAmount[i][j];
                    if (map[i][j] < 0) {
                        map[i][j] = 0;
                    }
                    meltAmount[i][j] = 0;
                }
            }
        }
    }

    public static int countIceberg() {
        boolean[][] visited = new boolean[N][M];
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[nr][nc] > 0 && !visited[nr][nc]) {
                    dfs(nr, nc, visited);
                }
            }
        }
    }


}
