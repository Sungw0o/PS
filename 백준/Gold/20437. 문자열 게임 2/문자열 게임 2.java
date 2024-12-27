import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String w = br.readLine();
            int K = Integer.parseInt(br.readLine());
            int minLen = minSubLen(K, w);

            if (minLen != -1) {
                int maxLen = maxSubLen(K, w);
                sb.append(minLen).append(" ").append(maxLen).append("\n");
            } else {
                sb.append("-1\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static int minSubLen(int K, String w) {
        int minLength = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int kCnt = 0;
            int left = 0;

            for (int right = 0; right < w.length(); right++) {
                if (w.charAt(right) == c) {
                    kCnt++;
                }

                while (kCnt == K) {
                    minLength = Math.min(minLength, right - left + 1);

                    if (w.charAt(left) == c) {
                        kCnt--;
                    }
                    left++;
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static int maxSubLen(int K, String w) {
        int maxLength = -1;

        for (char c = 'a'; c <= 'z'; c++) {
            int kCnt = 0;
            int left = 0;

            for (int right = 0; right < w.length(); right++) {
                if (w.charAt(right) == c) {
                    kCnt++;
                }

                while (kCnt == K) {
                    if (w.charAt(left) == c && w.charAt(right) == c) {
                        maxLength = Math.max(maxLength, right - left + 1);
                    }

                    if (w.charAt(left) == c) {
                        kCnt--;
                    }
                    left++;
                }
            }
        }

        return maxLength;
    }
}
