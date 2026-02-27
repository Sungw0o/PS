import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N,M,sum;
	private static int[][] arr;
	private static int[][] dp;
	
	private static final int[] dx = {0, 0, 1, -1}; 
    private static final int[] dy = {1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dp = new int[N][M];
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0,0));
	}
	
	
	public static int dfs(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		
		if(dp[x][y] != -1) return dp[x][y];
		
		
		dp[x][y] = 0;
		for(int i = 0; i < 4; i++) {
			int tx = x + dx[i];
			int ty = y + dy[i];
			if (rangeCheck(tx, ty) && arr[tx][ty] < arr[x][y]) {
			   dp[x][y]+=dfs(tx, ty);
			}
		}
		
		return dp[x][y];
	}
	
	
	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y< M;
	}
}
