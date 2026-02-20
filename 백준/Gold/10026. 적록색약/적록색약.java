import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int N;
	
	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	
	private static char[][] arr;
	private static boolean[][] visited;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N ; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		int normalCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, arr[i][j]); 
					normalCount++;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		
		visited = new boolean[N][N];
		
		int blindCount = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					dfs(i, j, arr[i][j]); 
					blindCount++;
				}
			}
		}
		
		System.out.println(normalCount + " " + blindCount);
		br.close();
	}
	
	
	public static void dfs(int x, int y, char targetColor) {
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int tr = x + dr[i];
			int tc = y + dc[i];
			
			if(rangeCheck(tr, tc) && !visited[tr][tc]) {
				if(arr[tr][tc] == targetColor) {
					dfs(tr, tc, targetColor);
				}
			}
		}
	}
	
	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
}
