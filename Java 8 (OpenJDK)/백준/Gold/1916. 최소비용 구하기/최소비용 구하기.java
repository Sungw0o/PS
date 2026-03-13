import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

	private static int[] dist;

	private static PriorityQueue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Edge(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int sPoint = Integer.parseInt(st.nextToken());
		int ePoint = Integer.parseInt(st.nextToken());

		dist[sPoint] = 0;
		pq.add(new Edge(sPoint, 0));

		while (!pq.isEmpty()) {

			Edge cur = pq.poll();

			if (dist[cur.to] < cur.cost)
				continue;

			for (Edge next : graph.get(cur.to)) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}

		sb.append(dist[ePoint]);

		System.out.println(sb);
		br.close();

	}

	public static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

}
