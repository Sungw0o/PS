import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, cnt;
	private static char[][] map;

	private static final int[] dr = { -1, 0, 1 };
	private static final int[] dc = { 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		cnt = 0;
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			if (dfs(i, 0))
				cnt++;
		}

		System.out.println(cnt);
		br.close();

	}

	public static boolean dfs(int x, int y) {
		if (y == C - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int tr = x + dr[i];
			int tc = y + dc[i];
			if (rangeCheck(tr, tc)) {
				map[tr][tc] = 'x';

				if (dfs(tr, tc)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C && map[x][y] == '.';
	}
}
