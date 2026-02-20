import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	
	private static int valid;
	
	private static final char WALL = '1';
	private static final char GOAL = '3';
	
	private static char[][] maze;
	private static boolean[][] visited;
	
	private static final int dr[] = {-1,1,0,0};
	private static final int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t<= 10; t++) {
			valid = 0;
			br.readLine();
			
			maze = new char[100][100];
			visited = new boolean[100][100];
			
			for(int i = 0; i < 100;i++) {
				maze[i] = br.readLine().toCharArray();
			}
			
			visited[1][1] = true;
			dfs(1,1);
			sb.append("#"+t+" ").append(valid).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void dfs(int x, int y) {
		
		if(maze[x][y] == GOAL) {
			valid++;
			return ;
		}
		
		for(int i = 0; i < 4; i++) {
			int tr = x + dr[i];
			int ty = y + dc[i];
			if(rangeCheck(tr, ty)) {
				if(maze[tr][ty]!= WALL) {
					visited[x][y] = true;
					dfs(tr,ty);
				}
			}
			
		}
	}
	
	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && x< 100 && y >=0 && y< 100 && !visited[x][y];
	}
	
}
