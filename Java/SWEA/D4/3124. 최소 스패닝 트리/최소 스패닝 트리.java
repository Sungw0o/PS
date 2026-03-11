import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int T, V, E;
	private static ArrayList<Node>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];
			visited = new boolean[V + 1];

			for (int i = 1; i <= V; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[u].add(new Node(v, w));
				graph[v].add(new Node(u, w));
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();

			pq.offer(new Node(1, 0));
			long mstCost = 0;
			int nodeCount = 0;

			while (!pq.isEmpty()) {
				Node current = pq.poll();

				if (visited[current.to])
					continue;

				visited[current.to] = true;
				mstCost += current.weight;
				nodeCount++;

				if (nodeCount == V)
					break;

				for (Node next : graph[current.to]) {
					if (!visited[next.to]) {
						pq.offer(next);
					}
				}
			}

			sb.append("#").append(t).append(" ").append(mstCost).append("\n");

		}

		System.out.println(sb);
		br.close();
	}

	public static class Node implements Comparable<Node> {
		int to, weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}