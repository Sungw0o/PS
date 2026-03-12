import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	private static int V, E, K;

	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	private static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		K = Integer.parseInt(br.readLine());

		dist = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, cost));
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(K, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.cost) {
				continue;
			}

			for (Node next : graph.get(cur.to)) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb);
		br.close();

	}

	public static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
