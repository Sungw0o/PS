
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> sequence = new Stack<Integer>(); // 수열을 저장할 스택
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 스택을 이용하여 주어진 수열을 만들 수 있는지 확인
        String result = stackSequence(arr);
        System.out.println(result);
    }

    // 스택을 이용하여 주어진 수열을 만들 수 있는지 확인하는 메소드
    public static String stackSequence(int[] arr) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int current = 1; // 스택에 넣을 다음 숫자
        for (int num : arr) {
            // 현재 숫자가 스택의 탑보다 크면 탑보다 큰 수가 나올 때까지 스택에 push
            while (current <= num) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }
            // 스택의 탑이 현재 숫자와 같으면 pop
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else { // 스택의 탑이 현재 숫자와 다르면 수열을 만들 수 없음
                return "NO";
            }
        }
        return sb.toString();
    }
}
