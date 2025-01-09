import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] titles = new String[N];
        int[] powerLimits = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = st.nextToken();
            powerLimits[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int charPower = Integer.parseInt(br.readLine());
            sb.append(findTitle(titles, powerLimits, charPower)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static String findTitle(String[] titles, int[] powerLimits, int charPower) {
        int low = 0;
        int high = powerLimits.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (charPower <= powerLimits[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return titles[low];
    }
}
