import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int ans = 0;
        int index = 0;

        while (index < N.length()) {
            ans++;
            String numStr = String.valueOf(ans);

            for (char digit : numStr.toCharArray()) {
                if (digit == N.charAt(index)) {
                    index++;
                    if (index == N.length()) {
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
}