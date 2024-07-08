import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class stackImpl {
    private int[] stack;
    private int top;

    public stackImpl() {
        stack = new int[10000];
        top = -1;
    }

    public void push(int x) {
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        return stack[top--];
    }

    public int size() {
        return top + 1;
    }

    public int empty() {
        if (top == -1) {
            return 1;
        }
        return 0;
    }

    public int top() {
        if (top == -1) {
            return -1;
        }
        return stack[top];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        stackImpl stack = new stackImpl();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
