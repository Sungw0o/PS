import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	private static final int MAX_NODE = 100005;

	private static int[][] trie = new int[MAX_NODE][10];
	private static boolean[] isEnd = new boolean[MAX_NODE];

	private static int nodeCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] arr = new String[N];

			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}

			Arrays.sort(arr);

			for (int i = 0; i < nodeCnt; i++) {
				for (int j = 0; j < 10; j++) {
					trie[i][j] = 0;
				}
				isEnd[i] = false;
			}
			nodeCnt = 1;

			boolean isConsistent = true;
			for (int i = 0; i < N; i++) {
				if (!insertAndCheck(arr[i])) {
					isConsistent = false;
					break;
				}
			}

			sb.append(isConsistent ? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	public static boolean insertAndCheck(String word) {
		int cur = 0;
		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - '0';

			if (trie[cur][c] == 0) {
				trie[cur][c] = nodeCnt++;
			}

			cur = trie[cur][c];

			if (isEnd[cur]) {
				return false;
			}
		}

		isEnd[cur] = true;
		return true;
	}
}