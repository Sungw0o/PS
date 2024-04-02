
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while (!(line = br.readLine()).equals(".")) {
            sb.append(line).append("\n");
        }

        String input = sb.toString().trim();
        String[] sentences = input.split("\n");

        for (int i=0;i<sentences.length;i++ ) {
            if (isBalanced(sentences[i])) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }


    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty()) return false;
                char openBracket = stack.pop();
                if ((openBracket == '(' && ch != ')') || (openBracket == '[' && ch != ']')) {
                    return false; 
                }
            }
        }

        return stack.isEmpty(); 
    }
}
