import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution{
	
	private static int N, maxCores, minCableLen;
	private static int[][] map;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	private static ArrayList<Point> coreList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreList = new ArrayList<>();
			
			maxCores = Integer.MIN_VALUE;
			minCableLen = Integer.MAX_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
						coreList.add(new Point(i, j));
					}
				}
			}
			
			dfs(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(minCableLen).append("\n");
		}
		System.out.print(sb);
		br.close();
	}
	
	public static void dfs(int idx, int cnt, int len) {
		
		if (cnt + (coreList.size() - idx) < maxCores) return;

		if(idx == coreList.size()) {
			if (cnt > maxCores) {
				maxCores = cnt;
				minCableLen = len;
			} else if (cnt == maxCores) {
				minCableLen = Math.min(minCableLen, len);
			}
			return;
		}
		
		Point cur = coreList.get(idx);
		
		for(int d = 0; d < 4; d++) {
			int count = isConnectable(cur.x, cur.y, d);
			
			if(count > 0) {
				setStatus(cur.x, cur.y, d, 2);
				
				dfs(idx + 1, cnt + 1, len + count);
				
				setStatus(cur.x, cur.y, d, 0);
			}
		}
		
		dfs(idx + 1, cnt, len);
	}
	
	public static int isConnectable(int r, int c, int d) {
		int count = 0;
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
			if(map[nr][nc] != 0) return 0;
			
			nr += dr[d];
			nc += dc[d];
			count++;
		}
		return count;
	}
	
	public static void setStatus(int r, int c, int d, int status) {
		int nr = r + dr[d];
		int nc = c + dc[d];
		
		while(nr >= 0 && nr < N && nc >= 0 && nc < N) {
			map[nr][nc] = status;
			nr += dr[d];
			nc += dc[d];
		}
	}
	
	public static class Point {
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}