import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private static int TC, N, M;
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		TC = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			int maxWeight = -1; 
			int left = 0;
			int right = N - 1;
			
			while(left < right) {
				int sum = arr[left] + arr[right];
				
				if(sum > M) {
				
					right--;
				} else {
					
					maxWeight = Math.max(maxWeight, sum);
					left++;
				}
			}
			
			System.out.printf("#%d %d\n", t, maxWeight);
          
		}
	}
}