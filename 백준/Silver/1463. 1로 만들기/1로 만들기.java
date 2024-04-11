

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        System.out.println(makeOne(n));
    }

    static int makeOne(int n) {
        if (n == 1) return 0;
        if (dp[n] > 0) return dp[n];

        int min = Integer.MAX_VALUE;
        if (n % 3 == 0) min = Math.min(min, makeOne(n / 3));
        if (n % 2 == 0) min = Math.min(min, makeOne(n / 2));
        min = Math.min(min, makeOne(n - 1));

        dp[n] = min + 1;

        return dp[n];
    }
}
