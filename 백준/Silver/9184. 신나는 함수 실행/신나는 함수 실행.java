import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int a,b,c,sum;
	
	private static int[][][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        dp = new int[21][21][21];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sum = 0;
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(exitCheck(a, b, c)) break;
			
			sum = w(a,b,c);
			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(sum).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static int w(int a,int b,int c) {
		
		if(a<=0 || b <= 0 || c <= 0) return 1;
		if(a> 20 || b> 20 || c> 20) return w(20,20,20);
		
		if (dp[a][b][c] != 0) return dp[a][b][c];
		
		if (a < b && b < c) dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		
		else dp[a][b][c]=  w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		
		return dp[a][b][c];

	}
	
	
	public static boolean exitCheck(int x,int y, int z) {
		return x == -1 && y == -1 && z == -1;
	}
}
