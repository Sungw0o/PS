import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static final char destination = '3';
	private static final char wall = '1';

	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	
	private static final int T = 10;
	
	private static int tcNum = 1;
	private static int result = 0;
	
	private static char[][] maze = new char[16][16];
	private static boolean[][] visited = new boolean[16][16];
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		for(int i = 1; i<= T ; i++) {
			clear();
			input();
			dfs(1,1);
			
			sb.append("#").append(i).append(" ").append(result).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void clear() {

		visited = new boolean[16][16];
		result = 0; 
	}
	
	public static void input() throws IOException {
		
		br.readLine();
		
		for(int i = 0; i < 16; i++) {
			maze[i] = br.readLine().toCharArray();
		}
	}
	
	public static void dfs(int x, int y) {
		
		if(result == 1) return;
		
		if(maze[x][y] == destination) {
			result = 1;
			return;
		}
		
		visited[x][y] = true;
		
		for(int i = 0; i< 4;i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if(rangeCheck(nx, ny) && maze[nx][ny] != wall && !visited[nx][ny]) {              
                dfs(nx, ny);
            }
		}
	}
	
	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && y >= 0 && x < 16 && y < 16;
	}	
}
