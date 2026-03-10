import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
	private static int T, N;
	private static int[][] arr;
	private static int[][] minCost;
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			minCost = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';
				}
				Arrays.fill(minCost[i], Integer.MAX_VALUE);
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, 0));
			minCost[0][0] = 0;

			int ans = 0;

			while (!pq.isEmpty()) {
				Node cur = pq.poll();

				if (cur.r == N - 1 && cur.c == N - 1) {
					ans = cur.cost;
					break;
				}

				for (int i = 0; i < 4; i++) {
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						int nextCost = cur.cost + arr[nr][nc];
						
						if (nextCost < minCost[nr][nc]) {
							minCost[nr][nc] = nextCost;
							pq.add(new Node(nr, nc, nextCost));
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.print(sb);
	}

	public static class Node implements Comparable<Node> {
		int r, c, cost;

		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}