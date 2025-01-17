import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String boom = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            stack.push(c); 

            if (stack.size() >= boom.length()) {
                boolean isBoom = true;

                for (int i = 0; i < boom.length(); i++) {
                    if (stack.get(stack.size() - boom.length() + i) != boom.charAt(i)) {
                        isBoom = false;
                        break;
                    }
                }

                if (isBoom) {
                    for (int i = 0; i < boom.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } 
        
        else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }
            System.out.println(result);
        }
    }
}
