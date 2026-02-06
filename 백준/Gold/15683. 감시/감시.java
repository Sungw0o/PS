import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, M;
	private static int minSize = Integer.MAX_VALUE;
	
	private static final int WALL = 6;
	private static final int WATCHED = -1;
	
	private static int[][] office;
	
	private static int[] dr = {-1, 0, 1, 0};
	private static int[] dc = {0, 1, 0, -1};
	
	private static int[][][] modes = {
		{}, 
		{{0}, {1}, {2}, {3}}, 
		{{0, 2}, {1, 3}},     
		{{0, 1}, {1, 2}, {2, 3}, {3, 0}}, 
		{{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, 
		{{0, 1, 2, 3}} 
	};
	
	private static List<CCTV> cctvList = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		office = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				
				if(office[i][j] != 0 && office[i][j] != WALL) {
					cctvList.add(new CCTV(office[i][j], i, j));
				}
			}
		}
		
		dfs(0, office);
		
		System.out.println(minSize);
		br.close();
	}
	
	public static void dfs(int cctvIdx, int[][] prevMap) {
		
		if(cctvIdx == cctvList.size()) {
			int count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(prevMap[i][j] == 0) {
						count++;
					}
				}
			}
			minSize = Math.min(minSize, count);
			return;
		}
		
		CCTV cur = cctvList.get(cctvIdx);
		
		for(int[] dirs : modes[cur.type]) {
			
			int[][] tempMap = new int[N][M];
			for(int i = 0; i < N; i++) {
				tempMap[i] = prevMap[i].clone();
			}
			
			for(int d : dirs) {
				watch(cur.x, cur.y, d, tempMap);
			}
			
			dfs(cctvIdx + 1, tempMap);
		}
	}
	
	public static void watch(int x, int y, int dir, int[][] map) {
		int nx = x;
		int ny = y;
		
		while(true) {
			nx += dr[dir];
			ny += dc[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == WALL) {
				break;
			}
			
			if(map[nx][ny] == 0) {
				map[nx][ny] = WATCHED;
			}
		}
	}
	
	public static class CCTV {
		int type, x, y;

		public CCTV(int type, int x, int y) {
			this.type = type;
			this.x = x;
			this.y = y;
		}		
	}
}