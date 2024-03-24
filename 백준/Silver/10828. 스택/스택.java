
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    stack.push(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    if (!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println("-1");
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? "1" : "0");
                    break;
                case "top":
                    if (!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println("-1");
                    break;
            }
        }
        br.close();
    }
}
