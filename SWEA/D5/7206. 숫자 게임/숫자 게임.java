import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution{
	
	static int N;
	static int[] memo = new int[100000];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			String line = br.readLine();
			if(line == null || line.trim().isEmpty()) {
				line = br.readLine();
			}
			N = Integer.parseInt(line);
			
			Arrays.fill(memo, -1);
			
			int result = game(N);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static int game(int num) {
		if (num < 10) {
			return 0;
		}
		
		if (memo[num] != -1) {
			return memo[num];
		}
		
		String s = String.valueOf(num);
		int len = s.length();
		int maxTurn = 0;
		
		for (int i = 1; i < (1 << (len - 1)); i++) {
			int product = 1;
			int start = 0;
			
			for (int j = 0; j < len - 1; j++) {
				if ((i & (1 << j)) != 0) {
					String part = s.substring(start, j + 1);
					product *= Integer.parseInt(part);
					start = j + 1; 
				}
			}
			
			String lastPart = s.substring(start);
			product *= Integer.parseInt(lastPart);
			
			int currentTurn = 1 + game(product);
			
			maxTurn = Math.max(maxTurn, currentTurn);
		}
		
		return memo[num] = maxTurn;
	}
}