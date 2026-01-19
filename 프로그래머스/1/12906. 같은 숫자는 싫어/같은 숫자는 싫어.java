import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public int[] solution(int[] arr) throws IOException {
		Stack<Integer> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i : arr) {
			if(stack.isEmpty() || !stack.peek().equals(i)) {
				stack.push(i);
			}
		}
		
		return stack.stream().mapToInt(i -> i).toArray();
	}

}