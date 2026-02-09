import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int N;
	
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		N = Integer.parseInt(br.readLine());
		
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
		
		System.out.println(sb);
		br.close();
	}
	
	public static void dfs(int n, int digits) {
		
		if(digits == N) {
			if(isPrime(n)) {
				sb.append(n).append("\n");
				return;
			}
		}
		
		
		for(int i = 1; i<= 9 ;i++) {
			if(isPrime(n)) {
				dfs(n * 10 + i, digits +1);
			}
		}
		
	}
	
	public static boolean isPrime(int n) {
		for(int i = 2; i<= n/2; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		
		return true;
	}

}
