import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> book1 = new HashMap<>();
        HashMap<String, Integer> book2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            book1.put(i, s);
            book2.put(s, i);
        }

        for (int i = 1; i <= M; i++) {
            String s = br.readLine();
            if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
                sb.append(book1.get(Integer.parseInt(s))).append('\n');
            } else {
                sb.append(book2.get(s)).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}