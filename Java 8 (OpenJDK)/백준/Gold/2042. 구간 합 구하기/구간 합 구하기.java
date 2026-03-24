import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, S;

	private static long[] tree;
	private static long[] arr;

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
				long val = Long.parseLong(st.nextToken());
				update(sIdx, val);
			} else if (cmd == 2) {
				int sIdx = Integer.parseInt(st.nextToken());
				int eIdx = Integer.parseInt(st.nextToken());

				sb.append(query(sIdx, eIdx)).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}

	public static void init(int N) {
		S = 1;
		while (S < N) {
			S *= 2;
		}

		tree = new long[S * 2];

		for (int i = 1; i <= N; i++) {
			tree[S + i - 1] = arr[i];
		}

		for (int i = S - 1; i >= 1; i--) {
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
		}
	}

	public static void update(int idx, long val) {
		int node = S + idx - 1;

		tree[node] = val;
		node /= 2;

		while (node > 0) {
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
			node /= 2;
		}
	}

	public static long query(int left, int right) {
		int l = S + left - 1;
		int r = S + right - 1;
		long sum = 0;

		while (l <= r) {

			if (l % 2 == 1) {
				sum += tree[l];
				l++;
			}

			if (r % 2 == 0) {
				sum += tree[r];
				r--;
			}
			l /= 2;
			r /= 2;
		}
		return sum;
	}

}