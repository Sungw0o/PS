import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int V, E, cnt;

	private static boolean[] visited;

	private static Queue<Integer> q = new LinkedList<>();

	private static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			graph[from].add(to);
			graph[to].add(from);
		}

		visited[1] = true;
		q.add(1);
		cnt = 0;

		while (!q.isEmpty()) {

			int cur = q.poll();

			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					cnt++;
					q.add(next);
				}
			}
		}

		System.out.println(cnt);

	}

}
