import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int result = isConvertible(S, T) ? 1 : 0;
        System.out.println(result);
        br.close();
    }

    public static boolean isConvertible(String S, String T) {
        StringBuilder t = new StringBuilder(T);

        while (t.length() > S.length()) {
            if (t.charAt(t.length() - 1) == 'A') {
                t.deleteCharAt(t.length() - 1);
            } else {
                t.deleteCharAt(t.length() - 1);
                t.reverse();
            }
        }

        return t.toString().equals(S);
    }
}
