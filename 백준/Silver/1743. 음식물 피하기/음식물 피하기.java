import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int cnt;

    static boolean[][] visited;
    static char[][] passage;
    static ArrayList<Integer> food = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        passage = new char[N][M];
        visited = new boolean[N][M];

        
        for (int i = 0; i < N; i++) {
            Arrays.fill(passage[i], '.');
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            passage[r - 1][c - 1] = '#';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && passage[i][j] == '#') {
                    cnt = 0;
                    dfs(i, j);
                    food.add(cnt);
                }
            }
        }


        int maxFood = Collections.max(food);
        System.out.println(maxFood);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && passage[nx][ny] == '#') {
                dfs(nx, ny);
            }
        }
    }
}
