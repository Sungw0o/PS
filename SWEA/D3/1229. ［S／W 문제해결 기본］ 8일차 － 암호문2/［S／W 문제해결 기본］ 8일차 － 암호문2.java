import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	private static ArrayList<String> secretCode;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		for (int T = 1; T <= 10; T++) {

			String line = br.readLine();
			while (line == null || line.trim().isEmpty()) {
				line = br.readLine();
			}
			int size = Integer.parseInt(line.trim());

			secretCode = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < size; i++) {
				while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
				secretCode.add(st.nextToken());
			}

			int cmdCnt = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cmdCnt; i++) {
				while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());

				char cmd = st.nextToken().charAt(0);
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				command(cmd, x, y, st);
			}

			sb.append("#").append(T);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(secretCode.get(i));
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}

	public static void command(char cmd, int x, int y, StringTokenizer st) {
		switch (cmd) {
		case 'I':
			for (int k = 0; k < y; k++) {
				secretCode.add(x++, st.nextToken());
			}
			break;

		case 'D':
			for (int k = 0; k < y; k++) {
				secretCode.remove(x);
			}
			break;
		}
	}
}