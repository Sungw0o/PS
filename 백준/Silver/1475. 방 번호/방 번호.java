import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] count = new int[10];
        
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        
        int sixNine = count[6] + count[9];
        count[6] = (sixNine + 1) / 2;
        count[9] = (sixNine + 1) / 2;
        
        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }
        
        System.out.println(max);
    }
}