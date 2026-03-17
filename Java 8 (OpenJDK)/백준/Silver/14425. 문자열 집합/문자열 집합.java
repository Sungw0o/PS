import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static final int MAX_NODE = 5_000_005;
	private static int N, M, cnt;

	private static int[][] trie = new int[MAX_NODE][26];
	private static boolean[] isEnd = new boolean[MAX_NODE];
	private static int nodeCnt = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			insert(str);

		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (search(str)) {
				cnt++;
			}
		}

		sb.append(cnt);
		System.out.println(cnt);
		br.close();
	}

	public static void insert(String word) {
		int cur = 0;

		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';

			if (trie[cur][c] == 0) {
				trie[cur][c] = nodeCnt++;
			}
			cur = trie[cur][c];
		}
		isEnd[cur] = true;
	}

	public static boolean search(String word) {
		int cur = 0;

		for (int i = 0; i < word.length(); i++) {
			int c = word.charAt(i) - 'a';

			if (trie[cur][c] == 0) {
				return false;
			}

			cur = trie[cur][c];
		}
		return isEnd[cur];
	}
}
