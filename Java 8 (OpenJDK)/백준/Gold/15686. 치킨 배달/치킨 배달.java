import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int mincDist;

	private static ArrayList<int[]> houses = new ArrayList<>();
	private static ArrayList<int[]> chickens = new ArrayList<>();

	private static boolean[] open;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mincDist = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int val = Integer.parseInt(st.nextToken());

				if (val == 1)
					houses.add(new int[] { i, j });
				else if (val == 2)
					chickens.add(new int[] { i, j });
			}
		}

		open = new boolean[chickens.size()];
		dfs(0, 0);
		sb.append(mincDist);
		System.out.print(sb.toString());
		br.close();
	}

	public static void dfs(int count, int start) {

		if (count == M) {
			calDist();
			return;
		}

		for (int i = start; i < chickens.size(); i++) {
			open[i] = true;
			dfs(count + 1, i + 1);
			open[i] = false;
		}
	}

	public static void calDist() {
		int totalDist = 0;

		for (int i = 0; i < houses.size(); i++) {
			int[] house = houses.get(i);
			int minDist = Integer.MAX_VALUE;

			for (int j = 0; j < open.length; j++) {
				if (open[j]) {
					int[] chickenHouse = chickens.get(j);

					int dist = Math.abs(house[0] - chickenHouse[0]) + Math.abs(house[1] - chickenHouse[1]);
					minDist = Math.min(minDist, dist);
				}
			}
			totalDist += minDist;
		}
		mincDist = Math.min(totalDist, mincDist);

	}
}