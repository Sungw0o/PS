import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int M, N;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());

			if (M == 0 && N == 0) {
				break;
			}

			parent = new int[M];
			for (int i = 0; i < M; i++) {
				parent[i] = i;
			}

			Edge[] edges = new Edge[N];
			long totalCost = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(x, y, z);

				totalCost += z;
			}

			Arrays.sort(edges);

			long mstCost = 0;
			int edgeCount = 0;

			for (Edge edge : edges) {
				if (union(edge.u, edge.v)) {
					mstCost += edge.weight;
					edgeCount++;
					if (edgeCount == M - 1) {
						break;
					}
				}
			}

			sb.append(totalCost - mstCost).append("\n");
		}
		
		System.out.print(sb);
	}

	public static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return false;

		parent[b] = a;
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