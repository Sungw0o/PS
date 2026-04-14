
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			boolean[][] dist = new boolean[N + 1][N + 1];
            
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                dist[a][b] = true;
            }
            
            for (int k = 1; k <= N; k++) {          
                for (int i = 1; i <= N; i++) {      
                    for (int j = 1; j <= N; j++) {  
                        if (dist[i][k] && dist[k][j]) {
                            dist[i][j] = true;
                        }
                    }
                }
            }
            
            int ans = 0; 
            
            for (int i = 1; i <= N; i++) {
                int knownCount = 0; 
                
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    
                    if (dist[i][j] || dist[j][i]) {
                        knownCount++;
                    }
                }
                
                if (knownCount == N - 1) {
                    ans++;
                }
            }
            
            sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
