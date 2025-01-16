import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static final char OPEN_BRACKETS = '(';
    private static final char CLOSE_BRACKETS = ')';

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> multiplierStack = new Stack<>();
        int totalLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                if (i + 1 < s.length() && s.charAt(i + 1) == OPEN_BRACKETS) {
                    stack.push(totalLength);
                    multiplierStack.push(c - '0');
                    totalLength = 0;
                }
                else {
                    totalLength++;
                }
            }

            else if (c == CLOSE_BRACKETS) {
                int innerLength = totalLength;
                totalLength = stack.pop();
                int multiplier = multiplierStack.pop();
                totalLength += innerLength * multiplier;
            }
        }

        System.out.println(totalLength);
        br.close();
    }
}
