import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] sequence;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sequence = new int[N];

        backTracking(0);
    }

    static boolean backTracking(int depth) {
        if (depth == N) {
            for(int i=0;i<N;i++){
                sb.append(sequence[i]);
            }
            System.out.println(sb);
            return true;
        }

        for (int i = 1; i <= 3; i++) {
            sequence[depth] = i;
            if (isValid(depth)) {
                if (backTracking(depth + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isValid(int depth) {
        for (int len = 1; len <= (depth + 1) / 2; len++) {
            boolean isSame = true;
            for (int j = 0; j < len; j++) {
                if (sequence[depth - j] != sequence[depth - len - j]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false;
        }
        return true;
    }

}
