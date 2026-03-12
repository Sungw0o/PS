import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	private static int T,N,K,ans;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1;  t<= T; t++) {
			
			ans = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
			String s = br.readLine();
			
			int len = N / 4;
			
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < N; j += len) {
					String hex = s.substring(j, j + len);
					set.add(Integer.parseInt(hex, 16));
				}
				s = s.charAt(N - 1) + s.substring(0, N - 1);
			}
			
			int count = 0;
			int ans = 0;
			for (int num : set) {
				count++;
				if (count == K) {
					ans = num;
					break;
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	
}
