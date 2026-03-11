import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		parent = new int[N + 1];

		Edge[] edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(a, b, c);
		}

		Arrays.sort(edges);

		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		long mstCost = 0;
		int edgeCount = 0;

		for (Edge edge : edges) {
			if (union(edge.u, edge.v)) {
				mstCost += edge.weight;
				edgeCount++;
				if (edgeCount == N - 1)
					break;
			}
		}

		System.out.println(mstCost);
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		parent[y] = x;
		return true;
	}

	public static class Edge implements Comparable<Edge> {

		int u, v, weight;

		public Edge(int u, int v, int weight) {
			this.u = u;
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}