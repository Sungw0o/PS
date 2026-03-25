import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, S;
	private static int[] arr, minTree, maxTree;

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

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sIdx = Integer.parseInt(st.nextToken());
			int eIdx = Integer.parseInt(st.nextToken());

			sb.append(minQuery(sIdx, eIdx)).append(" ").append(maxQuery(sIdx, eIdx)).append("\n");

		}

		System.out.println(sb);
		br.close();
	}

	public static void init(int N) {
		S = 1;

		while (S < N) {
			S *= 2;
		}

		minTree = new int[S * 2];
		maxTree = new int[S * 2];

		for (int i = 1; i <= N; i++) {
			minTree[S + i - 1] = arr[i];
			maxTree[S + i - 1] = arr[i];
		}

		for (int i = S - 1; i >= 1; i--) {
			minTree[i] = Math.min(minTree[i * 2], minTree[i * 2 + 1]);
			maxTree[i] = Math.max(maxTree[i * 2], maxTree[i * 2 + 1]);
		}
	}

	public static int minQuery(int s, int e) {
		int l = S + s - 1;
		int r = S + e - 1;
		int min = Integer.MAX_VALUE;
		;

		while (l <= r) {

			if (l % 2 == 1) {
				min = Math.min(min, minTree[l]);
				l++;
			}

			if (r % 2 == 0) {
				min = Math.min(min, minTree[r]);
				r--;
			}

			l /= 2;
			r /= 2;
		}

		return min;

	}

	public static int maxQuery(int s, int e) {

		int l = S + s - 1;
		int r = S + e - 1;
		int max = Integer.MIN_VALUE;

		while (l <= r) {

			if (l % 2 == 1) {
				max = Math.max(max, maxTree[l]);
				l++;
			}

			if (r % 2 == 0) {
				max = Math.max(max, maxTree[r]);
				r--;
			}

			l /= 2;
			r /= 2;
		}

		return max;
	}
}
