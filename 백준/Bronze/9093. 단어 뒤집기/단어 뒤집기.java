import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] input = br.readLine().toCharArray();
            for (char c : input) {
                if(c== ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else{
                    stack.push(c);
                }

            }

            while(!stack.isEmpty()){
                sb.append(stack.pop());
            }
            sb.append('\n');
        }



        System.out.println(sb);
        br.close();
    }
}
