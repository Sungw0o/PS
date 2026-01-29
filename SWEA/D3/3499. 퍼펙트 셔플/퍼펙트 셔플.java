import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			String[] cards = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}
			
			int mid = (N + 1) / 2;
			
			sb.append("#").append(t);
			
			for (int i = 0; i < mid; i++) {
				sb.append(" ").append(cards[i]);
				
				if (i + mid < N) {
					sb.append(" ").append(cards[i + mid]);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}