import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Integer[] rankList = new Integer[N];

        if (N > 0) {
            String[] scores = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                rankList[i] = Integer.parseInt(scores[i]);
            }
        }

        Arrays.sort(rankList, Collections.reverseOrder());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        if (N == P && score <= rankList[P - 1]) {
            System.out.println(-1);
            return;
        }

        System.out.println(findRank(rankList, score, P));
        br.close();
    }

    public static int findRank(Integer[] arr, int target, int P) {
        int rank = 1;
        int sameCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && !arr[i].equals(arr[i - 1])) {
                rank += sameCount;
                sameCount = 0;
            }

            sameCount++;

            if (arr[i] == target) {
                return rank;
            }

            if (arr[i] < target) {
                return rank;
            }
        }

        return rank + sameCount;
    }
}
