import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];
        int maxLength = 0;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < A; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < A; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < A; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
        br.close();
    }
}
