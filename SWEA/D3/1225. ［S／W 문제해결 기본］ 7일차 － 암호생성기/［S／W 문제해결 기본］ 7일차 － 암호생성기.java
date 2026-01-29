import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= 10; t++) {
			String tcNum = br.readLine(); 
			
			Queue<Integer> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
			
			int decrement = 1;
			
			while (true) {
				int num = queue.poll();
				
				num -= decrement;
				
				if (num <= 0) {
					num = 0;
					queue.offer(num);
					break;
				}
				
				queue.offer(num);
				
				decrement++;
				if (decrement > 5) {
					decrement = 1;
				}
			}
			
			sb.append("#").append(tcNum).append(" ");
			for (int n : queue) {
				sb.append(n).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}