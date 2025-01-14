import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] ch = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int curIdx = 0;

        while (true) {
            if (curIdx == ch.length) {
                break;
            }

            if (ch[curIdx] == '<') {
                while (ch[curIdx] != '>') {
                    sb.append(ch[curIdx]);
                    curIdx++;
                }
                sb.append(ch[curIdx]);
                curIdx++;
            } else {
                while (curIdx < ch.length && ch[curIdx] != '<' && ch[curIdx] != ' ') {
                    stack.push(ch[curIdx]);
                    curIdx++;
                }
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                if (curIdx < ch.length && ch[curIdx] == ' ') {
                    sb.append(' ');
                    curIdx++;
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
