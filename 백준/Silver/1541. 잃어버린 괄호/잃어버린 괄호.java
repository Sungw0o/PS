import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
	
	private static int minValue = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer sub = new StringTokenizer(br.readLine(),"-");
		
		while(sub.hasMoreTokens()) {
			
			int temp = 0;
			
			StringTokenizer add = new StringTokenizer(sub.nextToken(),"+");
			while(add.hasMoreTokens()) {
				temp += Integer.parseInt(add.nextToken());
			}	
				if(minValue == Integer.MAX_VALUE) {
					minValue = temp;
				}
				else {
					minValue -= temp;
				}		
		}
		
		sb.append(minValue);
		System.out.println(sb);
		br.close();
			
	}
}
