import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            HashMap<String, String> clothes = new HashMap<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                clothes.put(st.nextToken(), st.nextToken());
            }
            sb.append(combination(clothes)).append("\n");
        }
        System.out.print(sb);
    }
    
    static int combination(HashMap<String, String> clothes) {
        HashMap<String, Integer> typeCount = new HashMap<>();
        
        for (String type : clothes.values()) {
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        int result = 1;
        
        for (int count : typeCount.values()) {
            result *= (count + 1);
        }
        
        return result - 1;
    }
}
