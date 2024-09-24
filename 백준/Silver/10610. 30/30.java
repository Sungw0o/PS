import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        
        char[] digits = N.toCharArray();
        Arrays.sort(digits);  

        if (digits[0] != '0') {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (char digit : digits) {
            sum += digit - '0';
        }
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder(new String(digits));
        System.out.println(sb.reverse().toString());

        br.close();
    }
}
