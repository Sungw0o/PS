import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, N, ans, stX, stY;
	
	private static int[][] arr;
	private static boolean[] dessert; 
	
	// 사각형을 그리기 위한 순서: 우하-> 좌하-> 좌상-> 우상
	private static final int[] dr = {1, 1, -1, -1};
	private static final int[] dc = {1, -1, -1, 1};
	
	private static BufferedReader br;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= T; t++) {
			input();
			validPoint();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void input() throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		ans = -1; 
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	public static void validPoint() {
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N ; j++) {
				stX = i;
				stY = j;
				dessert = new boolean[101]; 
				dessert[arr[i][j]] = true; 
				dfs(i, j, 0, 1); 
			}
		}
	}
	
	public static void dfs(int x, int y, int dir, int count) {
		
		for(int i = dir; i < 4; i++) {
			int tr = x + dr[i];
			int tc = y + dc[i];
			
			if(checkRange(tr, tc)) {
				if(tr == stX && tc == stY && count >= 4) {
					ans = Math.max(ans, count);
					return;
				}
				
				if(!dessert[arr[tr][tc]]) {
					dessert[arr[tr][tc]] = true;     
					dfs(tr, tc, i, count + 1);       
					dessert[arr[tr][tc]] = false;    
				}
			}
		}
	}
	
	public static boolean checkRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}