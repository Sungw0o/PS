import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	private static int[] parent;

	private static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		makeSet(N);
		int result = 0;

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) {
				result = i;
				break;
			}
		}

		System.out.println(result);
		br.close();
	}

	public static void makeSet(int n) {

		parent = new int[N];

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

	}

	public static int find(int x) {

		if (parent[x] == x)
			return x;

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
