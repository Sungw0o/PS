import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int N,Q;
	
	private static final int INF = 987654321;
	
	private static int[][][] dist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1][N+1][N+1];
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				
				if(i == j) dist[0][i][j] = 0;
				else if(cost == 0) {
					dist[0][i][j] = INF;
				}
				
				else {
					dist[0][i][j] = cost;
				}
				
			}
		}
		
		
		for(int k = 1; k <= N; k++) { //거쳐가는
			for(int i = 1; i <= N; i++) { // 출발
				for(int j = 1 ; j <= N ; j++) { //도착
					dist[k][i][j] = Math.min(dist[k-1][i][j], dist[k - 1][i][k] + dist[k - 1][k][j]);
				}
			}
		}
		
		for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int ans = dist[C - 1][s][e];
            
            if (ans == INF) {
                sb.append("-1\n");
            } else {
                sb.append(ans).append("\n");
            }
        }
        
        System.out.print(sb);
        br.close();
	}
}
