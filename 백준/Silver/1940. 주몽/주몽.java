import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		int sIdx = 0;
		int eIdx = N - 1;
		
		while(sIdx < eIdx) {
			int sum = arr[sIdx] + arr[eIdx];
			
			if(sum < M) {
				sIdx++;
			} 
			else if (sum > M) {
				eIdx--;
			} 
			else {
				cnt++;
				sIdx++;
				eIdx--;
			}
		}
		
		System.out.println(cnt);
	}
}