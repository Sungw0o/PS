import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());



        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            if(isValid(str)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
        br.close();
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c =='('){
                stack.push(c);
            }
            else if(c ==')'){
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
