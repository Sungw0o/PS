import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int R,C,minTime;
	private static char[][] maze;
	
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	
	private static Queue<int []> fQ = new LinkedList<>();
	private static Queue<int []> jQ = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		maze = new char[R][C];
		minTime = 0;
		
		for(int i = 0; i< R; i++) {
			String input = br.readLine();
			for(int j = 0; j < C; j++) {
				maze[i][j] = input.charAt(j);
				if(maze[i][j] == 'J') {
					jQ.add(new int[] {i,j,0});
				}
				else if(maze[i][j] =='F') {
					fQ.add(new int[] {i,j});
				}
			}
		}
		
		minTime = bfs();
		if (minTime == -1) {
		    sb.append("IMPOSSIBLE");
		} else {
		    sb.append(minTime);
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
	public static int bfs() {
		
		while (!jQ.isEmpty()) {
			
			int fSize = fQ.size();
			for (int i = 0; i < fSize; i++) {
				int[] f = fQ.poll();
				int fr = f[0];
				int fc = f[1];
				
				for (int j = 0; j < 4; j++) {
					int nr = fr + dr[j];
					int nc = fc + dc[j];
					
					if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if (maze[nr][nc] == '.' || maze[nr][nc] == 'J') {
							maze[nr][nc] = 'F';
							fQ.add(new int[] {nr, nc});
						}
					}
				}
			}
			
			int jSize = jQ.size();
			for (int i = 0; i < jSize; i++) {
				int[] j = jQ.poll();
				int jr = j[0];
				int jc = j[1];
				int time = j[2];
				
				for (int k = 0; k < 4; k++) {
					int nr = jr + dr[k];
					int nc = jc + dc[k];
					
					if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
						return time + 1;
					}
					
					if (maze[nr][nc] == '.') {
						maze[nr][nc] = 'J';
						jQ.add(new int[] {nr, nc, time + 1});
					}
				}
			}
		}
		
		return -1;
	}

}
