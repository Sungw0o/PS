import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, t;
	private static int[][] map, dist;
	
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	
	private static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		t = 1;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			
			dist = new int[N][N];
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = map[0][0];
			
			pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(cur.cost > dist[cur.r][cur.c]) continue;
				
				for(int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(rangeCheck(nr,nc)) {
						int nextCost = cur.cost + map[nr][nc];
						
						if(dist[nr][nc] > nextCost) {
							dist[nr][nc] = nextCost;
							pq.add(new Node(nr, nc, nextCost));
						}
					}
				}
			}
			
			sb.append("Problem ").append(t++).append(": ").append(dist[N-1][N-1]).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static boolean rangeCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
	
	public static class Node implements Comparable<Node>{
		int r, c, cost;
		
		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.cost, n.cost);
		}
	}
}