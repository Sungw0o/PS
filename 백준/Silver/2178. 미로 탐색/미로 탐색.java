import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] maze;
	private static boolean[][] visited;
	private static int cnt = 0;
	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	private static int N,M;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i<N ; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		System.out.println(maze[N-1][M-1]);
		br.close();
		
	}
	
	public static void bfs(int sR,int sC) {
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {sR,sC});
		visited[sR][sC] = true;
		
		while(!queue.isEmpty()) {
			
			int[] curr =queue.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int i = 0; i< 4;i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr>= 0 && nr < N && nc >= 0 && nc < M) {
					if(maze[nr][nc] == 1 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						maze[nr][nc] = maze[r][c] + 1; 
	                    queue.offer(new int[] {nr, nc});
					}
				}
			}			
		}
	}
}
