import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            while (!stack.isEmpty() && stack.peek().height < height) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append(stack.peek().index).append(" ");
            }
            
            stack.push(new Node(height, i));
        }
        
        System.out.println(sb);
        br.close();
    }
}

class Node {
    int height;
    int index;
    
    Node(int height, int index) {
        this.height = height;
        this.index = index;
    }
}