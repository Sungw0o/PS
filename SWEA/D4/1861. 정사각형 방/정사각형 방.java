import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N;
	private static int[][] map;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxMove = 0;
			int roomNum = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = getMoveCount(i, j);

					if (cnt > maxMove) {
						maxMove = cnt;
						roomNum = map[i][j];
					} else if (cnt == maxMove) {
						roomNum = Math.min(roomNum, map[i][j]);
					}
				}
			}
			sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(maxMove).append("\n");
		}
		System.out.println(sb);
        br.close();
	}

	public static int getMoveCount(int r, int c) {
		int cnt = 1;
		while (true) {
			boolean moved = false;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (map[nr][nc] == map[r][c] + 1) {
						cnt++;
						r = nr;
						c = nc;
						moved = true;
						break;
					}
				}
			}
			if (!moved) break;
		}
		return cnt;
	}
}