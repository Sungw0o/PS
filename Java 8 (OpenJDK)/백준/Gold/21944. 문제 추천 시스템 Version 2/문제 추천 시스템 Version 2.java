import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	private static int N, M;
	private static Problem[] problemMap = new Problem[100_005];
	private static TreeSet<Problem> allProblems = new TreeSet<>();
	private static TreeSet<Problem>[] byCategory = new TreeSet[105];
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 100; i++) {
			byCategory[i] = new TreeSet<>();
		}

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			int category = Integer.parseInt(st.nextToken());
			
			Problem p = new Problem(num, level, category);
			problemMap[num] = p;
			allProblems.add(p);
			byCategory[category].add(p);
		}

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inputCommand(st);
		}

		System.out.print(sb);
		br.close();
	}

	public static class Problem implements Comparable<Problem> {
		int pNum, pLevel, pCategory;

		public Problem(int pNum, int pLevel, int pCategory) {
			this.pNum = pNum;
			this.pLevel = pLevel;
			this.pCategory = pCategory;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.pLevel != o.pLevel) {
				return this.pLevel - o.pLevel;
			}
			return this.pNum - o.pNum;
		}
	}

	public static void inputCommand(StringTokenizer st) {
		String cmd = st.nextToken();

		if (cmd.equals("add")) {
			int num = Integer.parseInt(st.nextToken());
			int level = Integer.parseInt(st.nextToken());
			int category = Integer.parseInt(st.nextToken());
			
			Problem p = new Problem(num, level, category);
			problemMap[num] = p;
			allProblems.add(p);
			byCategory[category].add(p);
			
		} else if (cmd.equals("recommend")) {
			int category = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			if (x == 1) {
				sb.append(byCategory[category].last().pNum).append("\n");
			} else {
				sb.append(byCategory[category].first().pNum).append("\n");
			}
			
		} else if (cmd.equals("recommend2")) {
			int x = Integer.parseInt(st.nextToken());

			if (x == 1) {
				sb.append(allProblems.last().pNum).append("\n");
			} else {
				sb.append(allProblems.first().pNum).append("\n");
			}
			
		} else if (cmd.equals("recommend3")) {
			int x = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			Problem dummy = new Problem(0, L, 0);

			if (x == 1) {
				Problem res = allProblems.ceiling(dummy);
				if (res == null) {
					sb.append("-1\n");
				} else {
					sb.append(res.pNum).append("\n");
				}
			} else {
				Problem res = allProblems.lower(dummy);
				if (res == null) {
					sb.append("-1\n");
				} else {
					sb.append(res.pNum).append("\n");
				}
			}
			
		} else if (cmd.equals("solved")) {
			int P = Integer.parseInt(st.nextToken());
			Problem target = problemMap[P];
			
			allProblems.remove(target);
			byCategory[target.pCategory].remove(target);
		}
	}
}