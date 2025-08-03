import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] puddles = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            puddles[i][0] = Integer.parseInt(st.nextToken()); 
            puddles[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(puddles, (a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;
        int endOfPlank = 0;

        for (int i = 0; i < N; i++) {
            int start = Math.max(puddles[i][0], endOfPlank);
            int end = puddles[i][1];

            if (start >= end) continue;

            int length = end - start;
            int boards = (length + L - 1) / L; 

            result += boards;
            endOfPlank = start + boards * L;
        }

        System.out.println(result);
        br.close();
    }
}