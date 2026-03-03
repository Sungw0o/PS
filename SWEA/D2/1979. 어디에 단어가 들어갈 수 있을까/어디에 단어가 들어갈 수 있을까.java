import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][N];
			
			int ans = 0;
			
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0 ; i < N; i++) {
			    int cnt = 0;
			    for (int j = 0; j < N; j++) {
			        if(arr[i][j] == 1) {
			            cnt++; 
			        } else { 
			            if(cnt == K) {
			                ans++; 
			            }
			            cnt = 0; 
			        }
			    }
			    
			    if(cnt == K) {
			        ans++;
			    }
			}
			
			for(int i = 0 ; i < N; i++) {
			    int cnt = 0;
			    for (int j = 0; j < N; j++) {
			        if(arr[j][i] == 1) {
			            cnt++; 
			        } else { 
			            if(cnt == K) {
			                ans++; 
			            }
			            cnt = 0; 
			        }
			    }
			    
			    if(cnt == K) {
			        ans++;
			    }
			}
			
			sb.append("#"+t+" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
		br.close();
		
		
	}

}
