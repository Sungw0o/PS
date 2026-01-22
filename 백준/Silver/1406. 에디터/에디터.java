import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	private static final String CMD_L = "L";
	private static final String CMD_D = "D";
	private static final String CMD_B = "B";
	private static final String CMD_P = "P";
	
	private static Deque<Character> leftDeq = new ArrayDeque<>();
	private static Deque<Character> rightDeq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String initialLine = br.readLine();
		
		for (char c : initialLine.toCharArray()) {
			leftDeq.addLast(c);
		}
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch (command) {
				case CMD_L:
					moveLeft();
					break;
					
				case CMD_D:
					moveRight();
					break;
					
				case CMD_B:
					delete();
					break;
					
				case CMD_P:
					char x = st.nextToken().charAt(0);
					insert(x);
					break;
			}
		}
		
		
		printResult(sb);
		br.close();
	}
	
	private static void moveLeft() {
		if (!leftDeq.isEmpty()) {
			rightDeq.addFirst(leftDeq.pollLast());
		}
	}
		
	private static void moveRight() {
		if (!rightDeq.isEmpty()) {
			leftDeq.addLast(rightDeq.pollFirst());
		}
	}
	
	private static void delete() {
		if (!leftDeq.isEmpty()) {
			leftDeq.pollLast();
		}
	}
	
	private static void insert(char c) {
		leftDeq.addLast(c);
	}
	
	private static void printResult(StringBuilder sb) {
		for (char c : leftDeq) {
			sb.append(c);
		}
		for (char c : rightDeq) {
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}