import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); 

        int[] lineStack = new int[N]; 

        
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            lineStack[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
        bw.write(solution(lineStack));
        bw.flush();
        bw.close();
    }

    
    static String solution(int[] stack){
        int orderValue = 1; 

        
        Stack<Integer> tmpStack = new Stack<>();

       
        for(int i = 0; i < stack.length; i++){
            if(stack[i] != orderValue){ 
                
                if(!tmpStack.isEmpty() && tmpStack.peek() == orderValue){
                    tmpStack.pop();
                    i--; 
                    orderValue++;
                }else{ 
                    tmpStack.push(stack[i]);
                }
            }else{ 
                orderValue++; 
            }
        }

        boolean result = true;

       
        for(int i = 0; i < tmpStack.size(); i++){
            int tValue = tmpStack.pop(); 

            if(tValue == orderValue){ 
                orderValue++;
            }else{ 
                result = false;
                break;
            }
        }

        return result ? "Nice" : "Sad";
    }
}