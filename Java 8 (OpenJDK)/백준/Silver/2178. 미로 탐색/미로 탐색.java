import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, time;
	private static int[][] map;
	private static boolean[][] visited;

	private static final int[] dr = { -1, 1, 0, 0 };
	private static final int[] dc = { 0, 0, -1, 1 };

	private static Queue<Block> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		time = 0;

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';

			}
		}

		q.add(new Block(0, 0, 0));

		while (!q.isEmpty()) {

			Block cur = q.poll();

			if (cur.R == N - 1 && cur.C == M - 1) {
				time = cur.dTime;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int tr = cur.R + dr[i];
				int tc = cur.C + dc[i];
				if (rangeCheck(tr, tc)) {
					visited[tr][tc] = true;
					q.add(new Block(tr, tc, cur.dTime + 1));
				}
			}
		}

		System.out.println(time+1);

	}

	public static boolean rangeCheck(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M && !visited[r][c] && map[r][c] == 1;
	}

	public static class Block {
		int R, C, dTime;

		public Block(int r, int c, int time) {
			this.R = r;
			this.C = c;
			this.dTime = time;
		}
	}
}
