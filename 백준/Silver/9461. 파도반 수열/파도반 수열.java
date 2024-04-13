

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] dp = new long[101];
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1; dp[2] = 1; dp[3]=1;
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            for(int j=4;j<=num;j++){
                dp[j] = dp[j-3] + dp[j-2];
            }
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb.toString());

    }
}
