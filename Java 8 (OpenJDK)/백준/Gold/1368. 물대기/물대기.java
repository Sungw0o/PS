import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N;

	private static int[][] graph;

	private static int[] minEdge;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		minEdge = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			int cost = Integer.parseInt(br.readLine());
			graph[0][i] = cost;
			graph[i][0] = cost;
		}

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i <= N; i++) {
			minEdge[i] = Integer.MAX_VALUE;
		}

		int ans = 0;
		minEdge[0] = 0;

		for (int i = 0; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int minIdx = -1;

			for (int j = 0; j <= N; j++) {
				if (!visited[j] && minEdge[j] < min) {
					min = minEdge[j];
					minIdx = j;
				}
			}

			if (minIdx == -1)
				break;

			visited[minIdx] = true;
			ans += min;

			for (int j = 0; j <= N; j++) {
				if (!visited[j] && graph[minIdx][j] != 0 && minEdge[j] > graph[minIdx][j]) {
					minEdge[j] = graph[minIdx][j];
				}
			}
		}

		sb.append(ans).append("\n");
		System.out.print(sb.toString());
	}
}