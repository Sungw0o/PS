import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, sP, eP;
	private static int[] dist, pre;

	private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

	private static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to, cost));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		sP = Integer.parseInt(st.nextToken());
		eP = Integer.parseInt(st.nextToken());

		dist = new int[N + 1];
		pre = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[sP] = 0;
		pq.add(new Node(sP, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dist[cur.to] < cur.cost)
				continue;

			for (Node next : graph.get(cur.to)) {
				if (dist[next.to] > dist[cur.to] + next.cost) {
					dist[next.to] = dist[cur.to] + next.cost;
					pq.add(new Node(next.to, dist[next.to]));
					pre[next.to] = cur.to;

				}
			}
		}

		ArrayList<Integer> route = new ArrayList<>();
		int current = eP;
		while (current != 0) {
			route.add(current);
			current = pre[current];
		}

		Collections.reverse(route);

		sb.append(dist[eP]).append("\n");
		sb.append(route.size()).append("\n");

		for (int i = 0; i < route.size(); i++) {
			sb.append(route.get(i)).append(" ");
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
