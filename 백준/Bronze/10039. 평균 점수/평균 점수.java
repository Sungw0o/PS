import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            
            if (score < 40) {
                sum += 40;
            } else {
                sum += score;
            }
        }
        
        System.out.println(sum / 5);
    }
}