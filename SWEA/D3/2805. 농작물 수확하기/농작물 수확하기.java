import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T,N,profit;
	
	private static char[][] farm;
	
	private static BufferedReader br;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T ; t++) {
			
			init();
			calc();
			sb.append("#"+t+" ").append(profit).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void init() throws Exception, IOException {
		
		N = Integer.parseInt(br.readLine());
		profit = 0;
		farm = new char[N][N];
		
		for(int i = 0 ; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			farm[i] = st.nextToken().toCharArray();
		}
	}
	
	public static void calc() {
		
		for(int i = 0 ; i < N ; i++) {
			int m = N / 2 ;
			int distance = Math.abs(i-m);
			
			for(int j = distance ; j < N - distance; j++) {
				profit += farm[i][j] - '0';
			}
		}				
	}
}
