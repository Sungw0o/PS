import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K, S;

	private static final int MOD = 1000000007;

	private static long[] arr, tree;

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
				int a = Integer.parseInt(st.nextToken());
				long b = Long.parseLong(st.nextToken());

				update(a, b);

			}

			else if (cmd == 2) {
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				sb.append(query(s, e)).append("\n");
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

		// 바닥 노드에 값 깔기
		for (int i = 0; i < S * 2; i++) {
			tree[i] = 1;
		}

		// 바닥 노드에 값 깔기
		for (int i = 1; i <= N; i++) {
			tree[S + i - 1] = arr[i];
		}

		// 2. 누락되었던 부모 노드 갱신 로직 추가 (곱셈 및 모듈러 적용)
		for (int i = S - 1; i >= 1; i--) {
			tree[i] = (tree[i * 2] * tree[i * 2 + 1]) % MOD;
		}
	}

	public static void update(int idx, long value) {
		int node = S + idx - 1;

		tree[node] = value;
		node /= 2;

		while (node > 0) {
			tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
			node /= 2;
		}
	}

	public static long query(int sIdx, int eIdx) {
		int l = S + sIdx - 1;
		int r = S + eIdx - 1;
		long sum = 1;

		while (l <= r) {
			if (l % 2 == 1) {
				sum = (sum * tree[l]) % MOD;
				l++;
			}

			if (r % 2 == 0) {
				sum = (sum * tree[r]) % MOD;
				r--;
			}
			l /= 2;
			r /= 2;
		}

		return sum;
	}
}
