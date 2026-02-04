import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main{
	
	private static int M,N,H,day;
	
	private static int[][] box;
	
	private static Queue<Point> queue = new LinkedList<>();
	
	private static final int ripe = 1;
	private static final int unripe = 0;
	
	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		H = Integer.parseInt(st.nextToken()); 
			
		box = new int[N * H][M];
		
		input();
		bfs();
		checkResult();
			br.close();
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(rangeCheck(nr,nc)) {
					if(cur.r / N == nr / N) {
						if(box[nr][nc] == unripe) {
							box[nr][nc] = box[cur.r][cur.c] + ripe;
							queue.add(new Point(nr, nc));
						}
					}
				}
			}
						
			int[] dh = {N, -N}; 
			for(int i = 0; i < 2; i++) {
				int nr = cur.r + dh[i];
				int nc = cur.c; 
				
				if(nr >= 0 && nr < N * H) {
					if(box[nr][nc] == unripe) {
						box[nr][nc] = box[cur.r][cur.c] + ripe;
						queue.add(new Point(nr, nc));
					}
				}
			}
		}
	}
	
	public static void checkResult() {
		day = 0;
		for(int i = 0; i < N * H; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				day = Math.max(day, box[i][j]);
			}
		}
		
		if(day == 0) System.out.println(0);
		else System.out.println(day - 1);
	}
	
	public static void input() throws IOException {
		
		for(int i = 0; i< box.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< box[i].length;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == ripe) {
					queue.add(new Point(i,j));
				}
			}	
		}
	}
	
	public static boolean rangeCheck(int nr, int nc) {
		
		return nr >= 0 && nr < N * H && nc >= 0 && nc < M;
	}
	
	public static class Point {
		int r, c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
