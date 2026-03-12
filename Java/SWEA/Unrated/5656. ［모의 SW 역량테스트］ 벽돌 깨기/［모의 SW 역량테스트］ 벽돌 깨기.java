import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int T, N, W, H, ans;
	private static int[][] arr;

	private static int[] dr = { -1, 1, 0, 0 };
	private static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r, c, power;

		public Point(int r, int c, int power) {
			this.r = r;
			this.c = c;
			this.power = power;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			arr = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, arr);

			if (ans == Integer.MAX_VALUE) {
				ans = 0;
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	public static void dfs(int count, int[][] map) {

		if (count == N) {
			int remain = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] > 0) {
						remain++;
					}
				}
			}
			ans = Math.min(ans, remain);
			return;
		}

		for (int c = 0; c < W; c++) {
			int r = -1;
			for (int i = 0; i < H; i++) {
				if (map[i][c] > 0) {
					r = i;
					break;
				}
			}

			if (r == -1) {
				dfs(count + 1, map);
				continue;
			}

			int[][] copyMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copyMap[i][j] = map[i][j];
				}
			}

			boomBFS(copyMap, r, c);
			down(copyMap);

			dfs(count + 1, copyMap);
		}
	}

	public static void boomBFS(int[][] map, int r, int c) {
		Queue<Point> q = new LinkedList<>();
		if (map[r][c] > 1) {
			q.add(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;

				for (int k = 1; k < p.power; k++) {
					nr += dr[d];
					nc += dc[d];

					if (rangeCheck(nr, nc) && map[nr][nc] > 0) {
						if (map[nr][nc] > 1) {
							q.add(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	public static void down(int[][] map) {
		for (int c = 0; c < W; c++) {
			ArrayList<Integer> list = new ArrayList<>();
			
			for (int r = H - 1; r >= 0; r--) {
				if (map[r][c] > 0) {
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}

			int nr = H - 1;
			for (int val : list) {
				map[nr][c] = val;
				nr--;
			}
		}
	}

	public static boolean rangeCheck(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

}