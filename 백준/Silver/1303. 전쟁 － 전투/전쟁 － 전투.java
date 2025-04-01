import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] ground;
    static boolean[][] visited;
    static int[][] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ground = new char[M][N];
        visited = new boolean[M][N];
        count = new int[M][N];

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                ground[i][j] = line.charAt(j);
            }
        }

        int myPower = 0;
        int enemyPower = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && ground[i][j] == 'W') {
                    int count = bfs(i, j, 'W');
                    myPower += count * count;
                }
                if (!visited[i][j] && ground[i][j] == 'B') {
                    int count = bfs(i, j, 'B');
                    enemyPower += count * count;
                }
            }
        }
        System.out.println(myPower + " " + enemyPower);
        br.close();
    }

    public static int bfs(int x, int y, char team) {
        Queue<Point> queue = new LinkedList<>();
        int cnt = 1;
        queue.add(new Point(x, y));
        visited[x][y] = true;
        count[x][y] = cnt++;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[nx][ny] || ground[nx][ny] != team) continue;

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                count[nx][ny] = cnt++;
                x = nx;
                y = ny;
            }
        }
        return count[x][y];
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
