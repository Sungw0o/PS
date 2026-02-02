import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, N, M;
	private static int max; 
	private static int[][] arr;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N]; 
			max = 0; 
			
			for(int i=0; i<N; i++) {
			    st = new StringTokenizer(br.readLine());
			    for(int j=0; j<N; j++) {
			        arr[i][j] = Integer.parseInt(st.nextToken());
			    }
			}
			
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					int sum = 0;
					for(int x=i; x<i+M; x++) {
						for(int y=j; y<j+M; y++) {
							sum += arr[x][y];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		} 
		
		br.close();
	}
}