

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 동전의 종류 수
        int k = Integer.parseInt(input[1]); // 만들어야 할 금액
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k == 0) break;
            if (k >= coins[i]) {
                count += k / coins[i];
                k %= coins[i];
            }
        }
        System.out.println(count);
    }
}
