import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] sequence;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        sequence = new int[M];

        for (int i = 1; i <= N; i++) {
            numbers[i-1] = i;
        }

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int x) {
        if (x == M) {
            for (int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");

            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
                sequence[x] = numbers[i];
                backTracking(x + 1);

        }
    }
}
