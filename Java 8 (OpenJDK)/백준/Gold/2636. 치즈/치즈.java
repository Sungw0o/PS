import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, time;
	private static int[][] map;
	private static boolean[][] isBorder;
	private static boolean[][] isAir;
	private static final int[] dx = { -1, 1, 0, 0 };
	private static final int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isBorder = new boolean[N][M];
		isAir = new boolean[N][M];
		time = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int preCountPiece = 0;

		findFirstHole(0, 0);
		findFirstborder();

		while (true) {
			int piece = countPiece();

			if (piece == 0) {
				sb.append(time).append("\n");
				sb.append(preCountPiece).append("\n");
				break;
			}

			preCountPiece = piece;
			time++;
			meltCheeze();
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void findFirstHole(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		isAir[r][c] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int tr = cur[0] + dx[i];
				int tc = cur[1] + dy[i];
				if (tr >= 0 && tr < N && tc >= 0 && tc < M && !isAir[tr][tc] && map[tr][tc] == 0) {
					isAir[tr][tc] = true;
					q.add(new int[] { tr, tc });
				}
			}
		}
	}

	public static void findFirstborder() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int tr = i + dx[k];
						int tc = j + dy[k];
						if (tr >= 0 && tr < N && tc >= 0 && tc < M && isAir[tr][tc]) {
							isBorder[i][j] = true;
							break;
						}
					}
				}
			}
		}
	}

	public static void meltCheeze() {
		Queue<int[]> newAirQ = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isBorder[i][j]) {
					map[i][j] = 0;
					isAir[i][j] = true;
					isBorder[i][j] = false;
					newAirQ.add(new int[] { i, j });
				}
			}
		}

		while (!newAirQ.isEmpty()) {
			int[] cur = newAirQ.poll();
			for (int k = 0; k < 4; k++) {
				int tr = cur[0] + dx[k];
				int tc = cur[1] + dy[k];
				if (tr >= 0 && tr < N && tc >= 0 && tc < M && !isAir[tr][tc] && map[tr][tc] == 0) {
					isAir[tr][tc] = true;
					newAirQ.add(new int[] { tr, tc });
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int tr = i + dx[k];
						int tc = j + dy[k];
						if (tr >= 0 && tr < N && tc >= 0 && tc < M && isAir[tr][tc]) {
							isBorder[i][j] = true;
							break;
						}
					}
				}
			}
		}
	}

	public static int countPiece() {
		int cheezeCnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cheezeCnt++;
				}
			}
		}

		return cheezeCnt;
	}
}