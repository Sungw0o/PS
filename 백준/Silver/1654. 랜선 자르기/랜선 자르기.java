import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long K, N;
    static long[] LAN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());

        LAN = new long[(int)K];

        for (int i = 0; i < K; i++) {
            LAN[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(LAN);
        System.out.println(binarySearch(LAN));

        br.close();
    }

    static long binarySearch(long[] lan) {
        long left = 1;
        long right = lan[(int)K - 1];
        long maxLength = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (long length : lan) {
                count += length / mid;
            }

            if (count >= N) {
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxLength;
    }
}
