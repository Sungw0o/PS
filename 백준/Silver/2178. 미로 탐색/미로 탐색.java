import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	 private static int N,M,time;
	 
	 private static int[][] map;
	 private static boolean[][] visited;
	 
	 private static final int[] dr = {-1,1,0,0};
	 private static final int[] dc = {0,0,-1,1};
	 
	 private static Queue<Node> q = new LinkedList<>();
	 public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		time = 0;
		
		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		q.add(new Node(0,0,0));
		
		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (cur.r == N - 1 && cur.c== M - 1) {
				time = cur.time;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int tr = cur.r + dr[i];
				int tc = cur.c + dc[i];
				if (rangeCheck(tr, tc)) {
					visited[tr][tc] = true;
					q.add(new Node(tr, tc, cur.time + 1));
				}
			}
		}

		System.out.println(time+1);
		br.close();
	}
	 
	public static boolean rangeCheck(int r, int c) {
			return r >= 0 && r < N && c >= 0 && c < M && !visited[r][c] && map[r][c] == 1;
	}
	 
	 
	public static class Node{
		int r,c,time ;
		
		public Node(int r, int c,int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
}
