import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] fruits = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int left = 0, max = 0, types = 0;

        for (int right = 0; right < N; right++) {
            if (count[fruits[right]] == 0) {
                types++;
            }
            count[fruits[right]]++;

            while (types > 2) {
                count[fruits[left]]--;
                if (count[fruits[left]] == 0) {
                    types--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        sb.append(max).append("\n");
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
        br.close();
    }
}