import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, N, L;
	private static int maxScore;
	private static Burger[] burgers; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			L = Integer.parseInt(st.nextToken()); 
			
			burgers = new Burger[N];
			maxScore = 0;
			
			for(int i = 0; i < N ; i++ ) { 
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				
				burgers[i] = new Burger(score, cal);
			}
			
			subSetBurger(0, 0, 0);
			
			sb.append("#").append(t).append(" ").append(maxScore).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	

	public static void subSetBurger(int cnt, int sumScore, int sumCal) {
		
		if(sumCal > L) {
			return;
		}
		
		if(cnt == N) {
			maxScore = Math.max(maxScore, sumScore);
			return;
		}
		
		subSetBurger(cnt + 1, sumScore + burgers[cnt].score, sumCal + burgers[cnt].cal);
		
		subSetBurger(cnt + 1, sumScore, sumCal);
	}
	
	public static class Burger {
		int score; 
		int cal;   
		
		public Burger(int score, int cal) {
			this.score = score;
			this.cal = cal;
		}
	}
}