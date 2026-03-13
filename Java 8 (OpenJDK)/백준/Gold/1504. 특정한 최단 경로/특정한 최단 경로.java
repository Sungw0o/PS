import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, E, a, b, c;

	private static int[] dist;
	private static boolean[] visited;

	private static PriorityQueue<Node> pq = new PriorityQueue<>();

	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		dist = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int pathA = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int pathB = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

		int ans = Math.min(pathA, pathB);

		if (ans >= 20000000) {
			ans = -1;
		}


		sb.append(ans);

		System.out.println(sb);
		br.close();

	}

	public static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		dist = new int[N + 1];

		Arrays.fill(dist, 20000000);

		dist[s] = 0;
		pq.add(new Node(s, 0));

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

		return dist[e];
	}

	public static class Node implements Comparable<Node> {
		int to, cost;

		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.cost, n.cost);
		}
	}
}
