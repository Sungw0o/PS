import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] arr;
	private static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i< R ; i++) {
			rotate();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static void rotate() {

		int count = Math.min(N, M) / 2; 
		
		for(int i = 0; i < count; i++) {
			int temp = arr[i][i]; 
			
			for(int j = i; j < M - 1 - i; j++) {
				arr[i][j] = arr[i][j+1];
			}
		
			for(int j = i; j < N - 1 - i; j++) {
				arr[j][M - 1 - i] = arr[j+1][M - 1 - i];
			}
			

			for(int j = M - 1 - i; j > i; j--) {
				arr[N - 1 - i][j] = arr[N - 1 - i][j-1];
			}
			
			for(int j = N - 1 - i; j > i; j--) {
				arr[j][i] = arr[j-1][i];
			}
			
			arr[i + 1][i] = temp;
		}
	}
}


