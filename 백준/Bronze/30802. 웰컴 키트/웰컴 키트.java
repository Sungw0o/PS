import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sizes = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			sizes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int countT = 0;
		for(int count : sizes) {
			countT += (count + T - 1) / T;
		}
		
		int countP_bundle = N / P;
		int countP_single = N % P;
		
		StringBuilder sb = new StringBuilder();
		sb.append(countT).append("\n");
		sb.append(countP_bundle).append(" ").append(countP_single);
		
		System.out.println(sb);
	}
}