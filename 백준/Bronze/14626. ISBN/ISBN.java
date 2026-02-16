import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int sum = 0;
        int starIndex = -1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int weight = (i % 2 == 0) ? 1 : 3;

            if (c == '*') {
                starIndex = i;
            } else {
                sum += (c - '0') * weight;
            }
        }

        for (int i = 0; i <= 9; i++) {
            int weight = (starIndex % 2 == 0) ? 1 : 3;
            if ((sum + i * weight) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}