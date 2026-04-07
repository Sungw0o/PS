import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	
	private static int N;
	private static int[] dp;
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N <= 2) {
			System.out.println(N);
			return;
		}
			
		dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i<= N; i++) {
			
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[N]);
		br.close();
	}
}
