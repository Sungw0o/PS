import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, S;

	private static long[] arr, tree, lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(N);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int sIdx = Integer.parseInt(st.nextToken());
				int eIdx = Integer.parseInt(st.nextToken());
				long val = Long.parseLong(st.nextToken());

				update(1, 1, S, sIdx, eIdx, val);

			}

			else if (cmd == 2) {
				int sIdx = Integer.parseInt(st.nextToken());
				int eIdx = Integer.parseInt(st.nextToken());

				long rangeSum = query(1, 1, S, sIdx, eIdx);
				sb.append(rangeSum).append("\n");
			}
		}

		System.out.println(sb);
		br.close();
	}

	public static void init(int N) {
		S = 1;
		while (S < N) {

			S *= 2;
		}

		tree = new long[S * 2];
		lazy = new long[S * 2];

		for (int i = 1; i <= N; i++) {
			tree[S + i - 1] = arr[i];
		}
		for (int i = S - 1; i > 0; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}

	public static void propagate(int node, int start, int end) {
		if (lazy[node] != 0) {
			tree[node] += lazy[node] * (end - start + 1);
		}

		if (start != end) {
			lazy[node * 2] += lazy[node];
			lazy[node * 2 + 1] += lazy[node];
		}

		lazy[node] = 0;
	}

	public static void update(int node, int start, int end, int left, int right, long val) {
		propagate(node, start, end);

		if (right < start || end < left)
			return;

		if (left <= start && end <= right) {
			lazy[node] += val;
			propagate(node, start, end);
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, left, right, val);
		update(node * 2 + 1, mid + 1, end, left, right, val);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	public static long query(int node, int start, int end, int left, int right) {

		propagate(node, start, end);

		if (right < start || end < left)
			return 0;

		if (left <= start && end <= right)
			return tree[node];

		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
	}
}
