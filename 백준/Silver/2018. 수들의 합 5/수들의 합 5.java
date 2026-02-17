import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int N,cnt,sum;
	private static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		
		for(int i = 1; i<= N ;i++) {
			arr[i] = i;
		}
		
		cnt = 1;
		sum = 1;
		int sIdx = 1;
		int eIdx = 1;
		
		while(eIdx != N) {
			
			if(sum == N) {
				cnt++;
				eIdx++;
				sum = sum + eIdx;
			}
			
			else if(sum > N) {
				sum = sum - sIdx;
				sIdx++;
			}
			
			else {
				eIdx++;
				sum = sum + eIdx;
			}
		}
		
		System.out.println(cnt);
		
	}

}
