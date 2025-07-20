import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            while (!dq.isEmpty() && dq.peekFirst() < i - L + 1) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && arr[dq.peekLast()] > arr[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            sb.append(arr[dq.peekFirst()]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }
}
