import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        TreeMap<String,String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }


        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("enter")) {
                sb.append(entry.getKey()).append("\n");
            }
        }

        // 최종 출력
        System.out.print(sb);
        br.close();

    }
}
