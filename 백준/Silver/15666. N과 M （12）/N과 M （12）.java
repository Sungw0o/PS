import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { 
	
	private static int N, M;
	private static int[] arr;
	private static int[] out; 
	private static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		out = new int[M]; 
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
				
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int start, int depth) {
		
		if(depth == M) {
			for(int i = 0; i < M; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		int before = 0;
		
		for(int i = start; i < N; i++) {
			if (before != arr[i]) {
				before = arr[i];
				out[depth] = arr[i];
				
				dfs(i, depth + 1);
			}
		}
	}
}