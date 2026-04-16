import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { 

    private static int K, W, H;
    private static boolean[][][] visited; // 3차원 방문 배열
    private static int[][] map;

    private static final int[] dr = {-1, 1, 0, 0}; // 원숭이 4방향
    private static final int[] dc = {0, 0, -1, 1};
    private static final int[] kr = {-2, -2, -1, -1, 1, 1, 2, 2}; 
    private static final int[] kc = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 

        map = new int[H][W];
        visited = new boolean[K + 1][H][W]; 

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.r == H - 1 && cur.c == W - 1) {
                return cur.move;
            }

            if (cur.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nr = cur.r + kr[i];
                    int nc = cur.c + kc[i];

                    if (rangeCheck(nr, nc) && map[nr][nc] == 0 && !visited[cur.k + 1][nr][nc]) {
                        visited[cur.k + 1][nr][nc] = true;
                        q.add(new Node(nr, nc, cur.k + 1, cur.move + 1));
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];

                if (rangeCheck(nr, nc) && map[nr][nc] == 0 && !visited[cur.k][nr][nc]) {
                    visited[cur.k][nr][nc] = true;
                    q.add(new Node(nr, nc, cur.k, cur.move + 1));
                }
            }
        }

        return -1;
    }

    public static class Node {
        int r, c, k, move;

        public Node(int r, int c, int k, int move) {
            this.r = r;
            this.c = c;
            this.k = k; 
            this.move = move; 
        }
    }

    public static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}