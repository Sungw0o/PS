import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	private static class Node implements Comparable<Node> {
		int to;
		long weight;

		public Node(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			long[] x = new long[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}

			long[] y = new long[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine());

			boolean[] visited = new boolean[N];
			PriorityQueue<Node> pq = new PriorityQueue<>();

			pq.add(new Node(0, 0));

			long totalCost = 0;
			int cnt = 0;

			while (!pq.isEmpty()) {
				Node current = pq.poll();

				if (visited[current.to]) {
					continue;
				}

				visited[current.to] = true;
				totalCost += current.weight;
				cnt++;

				if (cnt == N) {
					break;
				}

				for (int i = 0; i < N; i++) {
					if (!visited[i]) {
						long dist = (x[current.to] - x[i]) * (x[current.to] - x[i])
								+ (y[current.to] - y[i]) * (y[current.to] - y[i]);
						pq.add(new Node(i, dist));
					}
				}
			}

			long ans = Math.round(totalCost * E);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}