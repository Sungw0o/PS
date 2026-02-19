import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 
	
    private static int M, N, day;
    private static int[][] arr;
    private static Queue<Point> queue = new LinkedList<>();

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 

        arr = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        bfs();
        checkResult();
        
        System.out.println(day > 0 ? day - 1 : day);
        br.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dr[i];
                int y = cur.y + dc[i];
                
                if (rangeCheck(x, y) && arr[x][y] == 0) {
                    arr[x][y] = arr[cur.x][cur.y] + 1;
                    queue.add(new Point(x, y));
                }
            }
        }
    }

    public static void checkResult() {
        day = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) { 
                    day = -1;
                    return;
                }
                day = Math.max(day, arr[i][j]);
            }
        }
    }

    public static boolean rangeCheck(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M;
    }

    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}