import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int maxNum = 10000;
        int[] dp = calcNumtoDp(maxNum);

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int[] calcNumtoDp(int maxNum) {
        int[] dp = new int[maxNum + 1];
        dp[0] = 1;

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= maxNum; j++) {
                dp[j] += dp[j - i];
            }
        }

        return dp;
    }
}
