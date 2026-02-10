import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T,minCost;

	private static int[] prices;
	private static int[] month;
	
	private static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			init();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i< 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			minCost = Math.min(minCost, prices[3]);
			sb.append("#"+t+" ").append(minCost).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void init() {
		prices = new int[4];
		month = new int[12];
		minCost = Integer.MAX_VALUE;
	}
	
	public static void dfs(int cnt, int sum) {
		
		if(sum > minCost) return;
		
		if(cnt >= 12) {
			minCost = Math.min(sum, minCost);
			return;
		}
		
		if (month[cnt] == 0) {
			dfs(cnt + 1, sum);
		} else {
			
			dfs(cnt + 1, sum + (month[cnt] * prices[0]));
			dfs(cnt + 1, sum + prices[1]);
		}
		
		dfs(cnt+3,sum + prices[2]);
		
		
	}
}
