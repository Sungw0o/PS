import java.util.*;
import java.io.*;

public class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[N];
                
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == 'O' && arr[j] == 'B' && dp[j] != INF) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                } else if (arr[i] == 'J' && arr[j] == 'O' && dp[j] != INF) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                } else if (arr[i] == 'B' && arr[j] == 'J' && dp[j] != INF) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }
      
        System.out.println(dp[N - 1] == INF ? -1 : dp[N - 1]);
    }
}
