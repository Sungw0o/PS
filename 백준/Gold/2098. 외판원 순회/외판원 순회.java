import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 16_000_000;
    private static int N;
    private static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[1 << N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(tsp(0, 1));
        br.close();
    }

    public static int tsp(int current, int visited) {
        if (visited == (1 << N) - 1) {
            if (arr[current][0] == 0) return INF;
            return arr[current][0];
        }

        if (dp[visited][current] != -1) return dp[visited][current];

        dp[visited][current] = INF;

        for (int next = 0; next < N; next++) {
            if ((visited & (1 << next)) == 0 && arr[current][next] != 0) {
                dp[visited][current] = Math.min(dp[visited][current],
                        tsp(next, visited | (1 << next)) + arr[current][next]);
            }
        }

        return dp[visited][current];
    }
}
