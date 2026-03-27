import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private static int N, M, minNum, S;

	private static int[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(N);

		build();

		for (int i = 0; i < M; i++) {
			minNum = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int sIdx = Integer.parseInt(st.nextToken());
			int eIdx = Integer.parseInt(st.nextToken());
			sb.append(query(sIdx, eIdx)).append("\n");
		}

		System.out.println(sb);
		br.close();

	}

	public static void init(int N) {
		S = 1;

		while (S < N) {
			S *= 2;
		}

		tree = new int[S * 2];

		Arrays.fill(tree, Integer.MAX_VALUE);

		for (int i = 1; i <= N; i++) {
			tree[S + i - 1] = arr[i];
		}
	}

	public static void build() {
		for (int i = S - 1; i > 0; i--) {
			tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
		}
	}

	public static int query(int start, int end) {

		int l = start + S - 1;
		int r = end + S - 1;

		while (l <= r) {

			if (l % 2 == 1) {
				minNum = Math.min(minNum, tree[l]);
				l++;
			}

			if (r % 2 == 0) {
				minNum = Math.min(minNum, tree[r]);
				r--;
			}

			l /= 2;
			r /= 2;
		}

		return minNum;
	}
}
