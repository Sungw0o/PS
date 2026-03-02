import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int T,L,kR,kC,gR,gC;

    private static final int[] dr  = {-2,-1,1,2,2,1,-1,-2};
    private static final int[] dc = {1,2,2,1,-1,-2,-2,-1};

    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            T = Integer.parseInt(br.readLine());

            for (int i = 1; i <= T; i++) {
                L = Integer.parseInt(br.readLine());
                map = new int[L][L];
                visited = new boolean[L][L];

                StringTokenizer st = new StringTokenizer(br.readLine());

                kR = Integer.parseInt(st.nextToken());
                kC = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());

                gR = Integer.parseInt(st.nextToken());
                gC = Integer.parseInt(st.nextToken());

                bfs(kR,kC);

                sb.append(map[gR][gC]).append("\n");
            }

            System.out.println(sb);
            br.close();
    }

    public static void bfs(int u, int v) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{u, v});
        visited[u][v] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            if (curX == gR && curY == gC) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                int x = curX + dr[i];
                int y = curY + dc[i];

                if (rangeCheck(x, y)) {
                    visited[x][y] = true;
                    map[x][y] = map[curX][curY] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }

    public static boolean rangeCheck(int x, int y){
        return x >= 0  && y >= 0 && x < L && y < L && !visited[x][y];
    }
}
