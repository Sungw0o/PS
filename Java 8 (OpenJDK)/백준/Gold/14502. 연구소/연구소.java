import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int maxsafeArea = 0;
	private static int[][] map;

	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static ArrayList<Point> virusList = new ArrayList<>();
	private static ArrayList<Point> blankList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virusList.add(new Point(i, j));
				} else if (map[i][j] == 0) {
					blankList.add(new Point(i, j));
				}
			}
		}

		buildWall(0, 0);

		System.out.println(maxsafeArea);
		br.close();
	}

	public static void buildWall(int startIdx, int cnt) {

		if (cnt == 3) {
			spreadVirus();
			return;
		}

		int size = blankList.size();
		for (int i = startIdx; i < size; i++) {
			Point p = blankList.get(i);
			map[p.r][p.c] = 1;
			buildWall(i + 1, cnt + 1);
			map[p.r][p.c] = 0;
		}
	}

	public static void spreadVirus() {
		int[][] tempMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, M);
		}

		int[] qX = new int[64];
		int[] qY = new int[64];
		int head = 0, tail = 0;

		for (Point v : virusList) {
			qX[tail] = v.r;
			qY[tail] = v.c;
			tail++;
		}

		while (head < tail) {
			int x = qX[head];
			int y = qY[head];
			head++;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (tempMap[nx][ny] == 0) {
						tempMap[nx][ny] = 2;
						qX[tail] = nx;
						qY[tail] = ny;
						tail++;
					}
				}
			}
		}

		int safeArea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tempMap[i][j] == 0) {
					safeArea++;
				}
			}
		}

		if (safeArea > maxsafeArea) {
			maxsafeArea = safeArea;
		}
	}

	public static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
