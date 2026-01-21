import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        int sum = 0;
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            
            if (cur == '(') {
                
                stack.push(cur);
            } else { 
              
                stack.pop();
               
                if (input.charAt(i - 1) == '(') {
                    sum += stack.size(); 
                } else {
                    
                    sum += 1; 
                }
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}