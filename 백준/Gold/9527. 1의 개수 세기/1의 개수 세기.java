import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        
        long result = countOnes(b) - countOnes(a - 1);
        System.out.println(result);

        br.close();
    }
    
    public static long countOnes(long num) {
        if (num < 0) return 0; 
        long count = 0;
        long powerOfTwo = 1; 

        while (powerOfTwo <= num) {
            long totalPairs = (num + 1) / (powerOfTwo * 2); 
            long remainder = (num + 1) % (powerOfTwo * 2); 

            
            count += totalPairs * powerOfTwo;
            count += Math.max(0, remainder - powerOfTwo);

            powerOfTwo *= 2; 
        }

        return count;
    }
}
