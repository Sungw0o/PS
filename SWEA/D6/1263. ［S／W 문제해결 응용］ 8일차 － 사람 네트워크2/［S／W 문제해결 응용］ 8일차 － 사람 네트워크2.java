
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, N;
	private static final int INF = 987654321;
	private static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int connected = Integer.parseInt(st.nextToken());
					
					if(i == j) {
						dist[i][j] = 0; // 자기 자신
					} else if (connected == 1) {
						dist[i][j] = 1; // 연결되어 있으면 거리 1
					} else {
						dist[i][j] = INF; // 안 연결되어 있으면 무한대
					}
				}
			}
			
			for(int k = 0; k < N; k++) { 
				for(int i = 0; i < N; i++) { 
					for(int j = 0; j < N; j++) { 
						if(dist[i][k] != INF && dist[k][j] != INF) {
							dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
						}
					}
				}
			}
			
			int minCC = INF; // 최소 CC 값을 저장할 변수
			
			for(int i = 0; i < N; i++) {
				int sum = 0; // i번 사람의 CC 합계
				for(int j = 0; j < N; j++) {
					sum += dist[i][j];
				}
				// 모든 사람 중 가장 CC 합이 작은 값을 갱신
				minCC = Math.min(minCC, sum);
			}
			
			sb.append("#").append(t).append(" ").append(minCC).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}
}