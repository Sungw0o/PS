import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N;
	private static int minDiff = Integer.MAX_VALUE;
	
	private static int[] population;
	
	private static ArrayList<Integer>[] area;
	
	private static boolean[] isSelected; 

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		population = new int[N + 1];
		area = new ArrayList[N + 1];
		isSelected = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			area[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int neighbor = Integer.parseInt(st.nextToken());
				area[i].add(neighbor);
			}
		}

		subset(1);
		
		System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
		br.close();
	}

	private static void subset(int cnt) {
		if (cnt == N + 1) {
			check();
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);

		isSelected[cnt] = false;
		subset(cnt + 1);
	}

	private static void check() {
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) listA.add(i);
			else listB.add(i);
		}

		if (listA.size() == 0 || listB.size() == 0) return;

		if (isConnected(listA) && isConnected(listB)) {
			int sumA = 0;
			int sumB = 0;

			for (int node : listA) sumA += population[node];
			for (int node : listB) sumB += population[node];

			minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
		}
	}

	private static boolean isConnected(List<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];

		
		int start = list.get(0);
		q.offer(start);
		visited[start] = true;
		
		int count = 1; 

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : area[cur]) {
				if (list.contains(next) && !visited[next]) {
					visited[next] = true;
					q.offer(next);
					count++;
				}
			}
		}
		return count == list.size();
	}
}