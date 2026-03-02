import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int w,h,islandCnt;
    private static int[][] map;
    private static boolean[][] visited;

    private static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            islandCnt = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        islandCnt++;
                    }
                }
            }

            sb.append(islandCnt).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int r,int c){

        for (int i = 0; i < 8; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (rangeCheck(x, y)) {
                visited[x][y] = true;
                dfs(x, y);
            }
        }
    }


    public static boolean rangeCheck(int x, int y) {

        return x >= 0 && x < h && y >= 0 && y < w && !visited[x][y] && map[x][y] == 1;
    }
}
