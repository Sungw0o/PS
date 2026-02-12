import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] map;
    private static Shark babyShark;
    private static int totalTime = 0;

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, -1, 0, 1};

    static class Node implements Comparable<Node> {
        int r, c, dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if (this.dist != o.dist) {
                return this.dist - o.dist;
            }
            if (this.r != o.r) {
                return this.r - o.r;
            }
            return this.c - o.c;
        }
    }

    static class Shark {
        int r, c, size, eatCount;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
            this.size = 2;
            this.eatCount = 0;
        }

        public void move(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(totalTime);
        
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    babyShark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }
        br.close();
    }

    private static void solve() {
        while (true) {
            Node target = findTarget();

            if (target == null) {
                break;
            }

            eat(target);
        }
    }

    private static Node findTarget() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];

        pq.offer(new Node(babyShark.r, babyShark.c, 0));
        visited[babyShark.r][babyShark.c] = true;

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (map[current.r][current.c] != 0 && canEat(map[current.r][current.c])) {
                return current;
            }

            for (int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (rangeCheck(nr, nc) && !visited[nr][nc] && canMove(map[nr][nc])) {
                    visited[nr][nc] = true;
                    pq.offer(new Node(nr, nc, current.dist + 1));
                }
            }
        }

        return null;
    }

    private static void eat(Node target) {
        babyShark.move(target.r, target.c);
        totalTime += target.dist;
        map[target.r][target.c] = 0;
        babyShark.eatCount++;
        grow();
    }

    private static void grow() {
        if (babyShark.eatCount == babyShark.size) {
            babyShark.size++;
            babyShark.eatCount = 0;
        }
    }

    private static boolean canMove(int fishSize) {
        return fishSize <= babyShark.size;
    }

    private static boolean canEat(int fishSize) {
        return fishSize < babyShark.size;
    }

    private static boolean rangeCheck(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}