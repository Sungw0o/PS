import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] limit = new int[3];
	private static boolean[][] visited = new boolean[201][201];
	private static boolean[] ans = new boolean[201];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		limit[0] = Integer.parseInt(st.nextToken());
		limit[1] = Integer.parseInt(st.nextToken());
		limit[2] = Integer.parseInt(st.nextToken());

		bfs();

		for (int i = 0; i <= 200; i++) {
			if (ans[i]) {
				sb.append(i).append(" ");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

	public static void bfs() {
		Queue<State> q = new LinkedList<>();
		
		q.add(new State(0, 0, limit[2]));
		visited[0][0] = true;

		int[] from = { 0, 0, 1, 1, 2, 2 };
		int[] to = { 1, 2, 0, 2, 0, 1 };

		while (!q.isEmpty()) {
			State cur = q.poll();

			if (cur.amount[0] == 0) {
				ans[cur.amount[2]] = true;
			}

			for (int i = 0; i < 6; i++) {
				int[] next = { cur.amount[0], cur.amount[1], cur.amount[2] };
				
				int f = from[i];
				int t = to[i];

				if (next[f] == 0) continue;

				int water = Math.min(next[f], limit[t] - next[t]);
				
				next[f] -= water;
				next[t] += water;

				if (!visited[next[0]][next[1]]) {
					visited[next[0]][next[1]] = true;
					q.add(new State(next[0], next[1], next[2]));
				}
			}
		}
	}

	public static class State {
		int[] amount = new int[3];

		public State(int a, int b, int c) {
			amount[0] = a;
			amount[1] = b;
			amount[2] = c;
		}
	}
}