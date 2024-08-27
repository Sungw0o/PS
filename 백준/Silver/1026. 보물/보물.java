import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		ArrayList<Integer> arrA = new ArrayList<>();
		ArrayList<Integer> arrB = new ArrayList<>();
		int sum = 0;
		
		StringTokenizer a = new StringTokenizer(br.readLine());
		StringTokenizer b = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<n; i++) {
			arrA.add(Integer.parseInt(a.nextToken()));
			arrB.add(Integer.parseInt(b.nextToken()));
		}
		
		for(int i = 0; i<n; i++) {
			int min = Collections.min(arrA);
			int max = Collections.max(arrB);

			sum += (min * max);
			
			arrA.remove(Integer.valueOf(min));
			arrB.remove(Integer.valueOf(max));
		}
		
		System.out.println(sum);
		br.close();
	}
}