import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] dp = new long[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;

		for (int i = 4; i < dp.length; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N] % 10007);
	}

}
