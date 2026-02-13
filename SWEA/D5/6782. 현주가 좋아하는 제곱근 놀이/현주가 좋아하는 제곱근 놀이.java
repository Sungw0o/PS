
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	private static int T;
	private static long N, ans; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
			ans = 0;
			N = Long.parseLong(br.readLine().trim());
			
			while(N != 2) {
				if(N == 2) break;
				
				long root = (long) Math.sqrt(N);
				
				if(root * root == N) {
					N = root; 
					ans++;    
				} 
				else {
					long nextVal = root + 1;
					long nextSquare = nextVal * nextVal;
					
					ans += (nextSquare - N);
					
					ans++;
					
					N = nextVal;
				}
			}

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}