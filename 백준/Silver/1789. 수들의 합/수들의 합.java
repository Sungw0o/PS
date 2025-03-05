import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine()); 

        long sum = 0;
        long n = 0;

        while (sum + (n + 1) <= S) {
            n++;
            sum += n;
        }

        System.out.println(n);
        br.close();
    }
}
