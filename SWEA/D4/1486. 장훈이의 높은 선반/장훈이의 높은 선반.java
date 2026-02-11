import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N, B;
	private static int[] H;
	private static int minDiff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			H = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			minDiff = Integer.MAX_VALUE;
			
			generateSubset(0, 0);
			
			System.out.println("#" + tc + " " + minDiff);
            
        }
        br.close();
	}
	
	public static void generateSubset(int cnt, int sum) {
		if (sum >= B) {
			minDiff = Math.min(minDiff, sum - B);
			return;
		}
		
		if (cnt == N) {
			return;
		}
		
		generateSubset(cnt + 1, sum + H[cnt]);
		generateSubset(cnt + 1, sum);
	}
}