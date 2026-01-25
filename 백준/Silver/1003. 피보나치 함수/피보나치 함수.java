import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] memo = new int[41][2];

        memo[0][0] = 1;
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;
        
        for (int i = 2; i <= 40; i++) {
            memo[i][0] = memo[i - 1][0] + memo[i - 2][0];
            memo[i][1] = memo[i - 1][1] + memo[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(memo[n][0]).append(" ").append(memo[n][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
