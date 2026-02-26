import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 2];
        int[] P = new int[N + 2];
        int[] dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + T[i] > N + 1) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], P[i] + dp[i + T[i]]);
            }
        }

        System.out.println(dp[1]);
        br.close();
    }
}