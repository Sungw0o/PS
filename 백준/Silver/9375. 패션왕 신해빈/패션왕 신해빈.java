import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            Map<String, Integer> clothesMap = new HashMap<>();

            for (int j = 0; j < num; j++) {
                String[] wear = br.readLine().split(" ");
                String type = wear[1];
                
                if (clothesMap.containsKey(type)) {
                    clothesMap.put(type, clothesMap.get(type) + 1);
                } else {
                    clothesMap.put(type, 1);
                }
            }

            int totalCount = 1;
            for (int count : clothesMap.values()) {
                totalCount *= (count + 1); 
            }
            
            int result = totalCount - 1;
            System.out.println(result);
        }
    }
}
