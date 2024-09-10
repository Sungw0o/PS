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
            for (int j = i + day[i]; j <= N; j++) {
                dp[j] = Math.max(dp[j], dp[i] + money[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
