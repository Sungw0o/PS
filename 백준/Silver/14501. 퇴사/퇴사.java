import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N];
        int[] money = new int[N];
        int[] dp = new int[N + 1]; 

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if (i + day[i] <= N) {
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + money[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        
        System.out.println(dp[N]);
        br.close();
    }
}
