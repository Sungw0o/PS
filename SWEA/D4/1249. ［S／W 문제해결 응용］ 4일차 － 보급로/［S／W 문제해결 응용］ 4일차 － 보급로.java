import java.util.*;
import java.io.FileInputStream;

class Solution {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                String line = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs();
            System.out.println("#" + test_case + " " + dist[N - 1][N - 1]);
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = p.x + dx[dir];
                int ny = p.y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    int newCost = dist[p.x][p.y] + map[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }
}
