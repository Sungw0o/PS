import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
	private static int T, Q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			Q = Integer.parseInt(br.readLine());
			
			TreeMap<Integer, Integer> map = new TreeMap<>();

			for (int i = 0; i < Q; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (cmd.equals("I")) {
					map.put(num, map.getOrDefault(num, 0) + 1);
				} 
				else if (cmd.equals("D")) {
					if (map.isEmpty()) continue;

					int key = (num == 1) ? map.lastKey() : map.firstKey();
					int count = map.get(key);

					if (count == 1) {
						map.remove(key);
					} else {
						map.put(key, count - 1);
					}
				}
			}

			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}

		System.out.print(sb);
		br.close();
	}
}