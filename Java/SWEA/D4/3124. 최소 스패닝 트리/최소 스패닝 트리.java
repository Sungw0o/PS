import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int T, V, E;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 1; i <= E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				graph.get(from).add(new Edge(to, weight));
				graph.get(to).add(new Edge(from, weight));
			}

			boolean[] visited = new boolean[V + 1];

			PriorityQueue<Edge> pq = new PriorityQueue<>();

			pq.add(new Edge(1, 0));

			long totalweight = 0;

			int nodeCount = 0;

			while (!pq.isEmpty()) {
				Edge cur = pq.poll();

				if (visited[cur.to])
					continue;

				visited[cur.to] = true;
				totalweight += cur.weight;
				nodeCount++;

				if (nodeCount == V)
					break;

				for (Edge next : graph.get(cur.to)) {
					if (!visited[next.to]) {
						pq.offer(next);
					}
				}
			}

			sb.append("#").append(t).append(" ").append(totalweight).append("\n");

		}

		System.out.println(sb);
		br.close();
	}

	public static class Edge implements Comparable<Edge> {
		int to;
		int weight;

		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}