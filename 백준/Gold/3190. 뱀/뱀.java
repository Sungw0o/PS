import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Queue<int[]> directions = new LinkedList<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directions.add(new int[]{time, dir});
        }

        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        int time = 0;

        while (true) {
            time++;
            int[] head = snake.peekLast();
            int nx = head[0] + moves[direction][0];
            int ny = head[1] + moves[direction][1];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                break;
            }

            snake.addLast(new int[]{nx, ny});
            
            visited[nx][ny] = true;

            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
            } 
            else {
                int[] tail = snake.pollFirst();
                visited[tail[0]][tail[1]] = false;
            }

            if (!directions.isEmpty() && directions.peek()[0] == time) {
                int[] change = directions.poll();
                if (change[1] == 'D') {
                    direction = (direction + 1) % 4;
                } 
                else {
                    direction = (direction + 3) % 4;
                }
            }
        }

        System.out.println(time);
        br.close();
    }
}
