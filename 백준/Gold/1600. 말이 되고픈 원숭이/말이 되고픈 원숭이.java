import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int K, W, H;
    private static boolean[][][] visited;
    private static int[][] arr;

    private static final int[] h_dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] h_dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static final int[] m_dr = {1, -1, 0, 0};
    private static final int[] m_dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); 
        H = Integer.parseInt(st.nextToken()); 


        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) { 
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) { 
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
        br.close();
    }

    public static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(0, 0, 0, K));
        visited[0][0][K] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.r == H - 1 && current.c == W - 1) {
                return current.cnt;
            }

            if (current.k > 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = current.r + h_dr[i];
                    int nc = current.c + h_dc[i];

                    if (rangeCheck(nr, nc) && arr[nr][nc] != 1) {
                        if (!visited[nr][nc][current.k - 1]) {
                            visited[nr][nc][current.k - 1] = true;
                            queue.offer(new Node(nr, nc, current.cnt + 1, current.k - 1));
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + m_dr[i];
                int nc = current.c + m_dc[i];

                if (rangeCheck(nr, nc) && arr[nr][nc] != 1) {
                    if (!visited[nr][nc][current.k]) {
                        visited[nr][nc][current.k] = true;
                        queue.offer(new Node(nr, nc, current.cnt + 1, current.k));
                    }
                }
            }
        }

        return -1; 
    }

    public static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }

    public static class Node {
        int r, c, cnt, k; 

        public Node(int r, int c, int cnt, int k) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.k = k;
        }
    }
}