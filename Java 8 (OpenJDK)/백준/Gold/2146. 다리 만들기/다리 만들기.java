import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, minLen;
	private static int[][] map;
	private static boolean[][] visited;

	private static final int[] dr = { -1, 1, 0, 0 };
	private static final int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		minLen = Integer.MAX_VALUE; 

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int islandNo = 2; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					findIsland(i, j, islandNo);
					islandNo++;
				}
			}
		}


		for (int i = 2; i < islandNo; i++) {
			buildBridge(i);
		}

		System.out.println(minLen);
		br.close();
	}

	public static void findIsland(int r, int c, int no) {
		visited[r][c] = true;
		map[r][c] = no; 

		for (int i = 0; i < 4; i++) {
			int tr = r + dr[i];
			int tc = c + dc[i];
			if (tr >= 0 && tr < N && tc >= 0 && tc < N) {
				if (!visited[tr][tc] && map[tr][tc] == 1) {
					findIsland(tr, tc, no);
				}
			}
		}
	}

	public static void buildBridge(int currentIsland) {
		Queue<Bridge> q = new LinkedList<>();
		boolean[][] bfsVisited = new boolean[N][N]; 

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == currentIsland) {
					q.add(new Bridge(i, j, 0));
					bfsVisited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Bridge cur = q.poll();

			if (cur.len >= minLen) continue;

			for (int i = 0; i < 4; i++) {
				int tr = cur.r + dr[i];
				int tc = cur.c + dc[i];

				if (tr >= 0 && tr < N && tc >= 0 && tc < N) {
					if (!bfsVisited[tr][tc]) {
						if (map[tr][tc] == 0) {
							bfsVisited[tr][tc] = true;
							q.add(new Bridge(tr, tc, cur.len + 1));
						} else if (map[tr][tc] != currentIsland) {
							minLen = Math.min(minLen, cur.len);
							return; 
						}
					}
				}
			}
		}
	}

	public static class Bridge {
		int r, c, len;

		public Bridge(int r, int c, int len) {
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}
}