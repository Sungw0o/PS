import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] answer = new int[N];  
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                answer[idx] = arr[i];
            }
            stack.push(i); 
        }
        
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            sb.append(num).append(' ');
        }
        
        System.out.println(sb);
        br.close();
    }
}