import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
    
    static int precedence(char c) {
        if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return 0;
        }
    }
}