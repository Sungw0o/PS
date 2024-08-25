import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] dp;
    static int[] weights;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        weights = new int[N + 1];
        values = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());

        }

        dp = new int[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) { 
                dp[i][j] = dp[i - 1][j];
                if (j - weights[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }

}