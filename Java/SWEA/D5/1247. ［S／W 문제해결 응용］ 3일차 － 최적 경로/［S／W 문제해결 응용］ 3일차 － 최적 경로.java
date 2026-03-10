import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int startX, startY, endX, endY;
    static int[][] customers;
    static boolean[] visited;
    static int minDistance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            customers = new int[N][2];
            for (int i = 0; i < N; i++) {
                customers[i][0] = Integer.parseInt(st.nextToken());
                customers[i][1] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N];
            minDistance = Integer.MAX_VALUE;

            dfs(0, startX, startY, 0);

            sb.append("#").append(t).append(" ").append(minDistance).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void dfs(int depth, int x, int y, int dist) {
        if (dist >= minDistance) return;

        if (depth == N) {
            dist += Math.abs(x - endX) + Math.abs(y - endY);
            if (dist < minDistance) {
                minDistance = dist;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int nextDist = dist + Math.abs(x - customers[i][0]) + Math.abs(y - customers[i][1]);
                dfs(depth + 1, customers[i][0], customers[i][1], nextDist);
                visited[i] = false;
            }
        }
    }
}