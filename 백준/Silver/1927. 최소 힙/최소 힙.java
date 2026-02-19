import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		N = Integer.parseInt(br.readLine());
		
		
		while(N--> 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
			    if (pq.isEmpty()) {
			        System.out.println(0);
			    } else {
			        System.out.println(pq.poll());
			    }
			} else {
			    pq.add(x);
			}
		}
		br.close();
	}
}
