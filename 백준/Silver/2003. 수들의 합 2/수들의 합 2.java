import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, cnt;
    private static int[] arr; 

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i + 1] = arr[i] + num;
        }
        
        int l = 0;
        int r = 0;
        cnt = 0;

        while (r <= N) {

            int currentSum = arr[r] - arr[l];

            if (currentSum < M) {
                r++;
            } else if (currentSum > M) {
                l++;
            } else { 
                cnt++;
                l++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}