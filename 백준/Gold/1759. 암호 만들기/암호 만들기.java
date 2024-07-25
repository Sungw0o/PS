import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] alpha;
    static String gather = "aeiou";
    static String[] pwd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        alpha = new String[C];
        pwd = new String[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alpha[i] = st.nextToken();
        }

        Arrays.sort(alpha);
        backTracking(0, 0);
    }

    static void backTracking(int index, int depth) {
        if (depth == L) {
            if (isValidPassword()) {
                System.out.println(String.join("", pwd));
            }
            return;
        }

        for (int i = index; i < C; i++) {
            pwd[depth] = alpha[i];
            backTracking(i + 1, depth + 1);
        }
    }

    static boolean isValidPassword() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (String s : pwd) {
            if (gather.contains(s)) {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}

