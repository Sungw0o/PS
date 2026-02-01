import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, L;
    private static int[][] map;
    private static boolean[][] isBody;
    private static Map<Integer, Character> dirInfo = new HashMap<>();

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        isBody = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            dirInfo.put(time, dir);
        }

        solve();
        br.close();
    }

    private static void solve() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        isBody[0][0] = true;

        int time = 0;
        int dir = 0;

        while (true) {
            time++;

            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            if (isOutOfBounds(nx, ny) || isBody[nx][ny]) {
                break;
            }

            snake.addLast(new int[]{nx, ny});
            isBody[nx][ny] = true;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } else {
                int[] tail = snake.pollFirst();
                isBody[tail[0]][tail[1]] = false;
            }

            if (dirInfo.containsKey(time)) {
                char turn = dirInfo.get(time);
                if (turn == 'D') {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (dir + 3) % 4;
                }
            }
        }

        System.out.println(time);
    }

    private static boolean isOutOfBounds(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}