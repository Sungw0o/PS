import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            String line = br.readLine(); 
            String[] numbers = line.trim().split("\\s+");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j]; 
        }


        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        System.out.println(dp[0][0]);
        
        br.close();
    }
}
