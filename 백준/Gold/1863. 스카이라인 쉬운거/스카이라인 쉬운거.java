import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int buildCnt = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
            }


            if (!stack.isEmpty() && stack.peek() == y) {
                continue;
            }

            if (y > 0) {
                stack.push(y);
                buildCnt++;
            }
        }

        System.out.println(buildCnt);
    }
}
