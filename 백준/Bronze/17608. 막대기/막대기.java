import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			int h = Integer.parseInt(br.readLine());
			stack.push(h);
		}
		
		int cnt = 0;
		int maxHeight = 0; 
		
		while(!stack.isEmpty()) {
			int current = stack.pop(); 
			
			if(current > maxHeight) {
				cnt++;
				maxHeight = current; 
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}