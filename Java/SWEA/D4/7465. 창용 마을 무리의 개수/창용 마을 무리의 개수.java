import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int T, N, M;

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];

			makeSet(N);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				if (parent[i] == i) {
					cnt++;
				}
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static void makeSet(int n) {
		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {

		if (parent[x] == x) {
			return x;

		}

		return parent[x] = find(parent[x]);
	}

	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return false;
		}

		parent[rootB] = rootA;
		return true;
	}
}
