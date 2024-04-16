import java.io.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n + 1];

            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                //현재 구할 값의 개수는 전 값의 +1이니 전 값을 그대로 우선 가져온다.
                dp[i] = dp[i - 1];
                for (int j = 1; j * j <= i; j++) {
                    //현재 들어가있는 값과, i - j * j의 값과 비교해서 작은 값을 다시 저장
                    dp[i] = Math.min(dp[i], dp[i - (j * j)]);
                }
                //최솟값이 저장되었을테니 +1을 해서 마무리 해준다.
                dp[i]++;
            }
            System.out.println(dp[n]);
    }
}