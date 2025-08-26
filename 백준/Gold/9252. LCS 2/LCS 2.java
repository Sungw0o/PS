import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = str1.length();
        int m = str2.length();

        
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int lcsLength = dp[n][m];
        System.out.println(lcsLength);
        
        if (lcsLength > 0) {
            StringBuilder lcs = new StringBuilder();
            int i = n;
            int j = m;

            while (i > 0 && j > 0) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcs.append(str1.charAt(i - 1));
                    i--;
                    j--;
                }
                else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    i--;
                }
                
                else {
                    j--;
                }
            }
            
            System.out.println(lcs.reverse());
        }
    }
}