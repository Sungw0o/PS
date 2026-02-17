import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long result = 0; 
        long[] cnt = new long[M]; 
        long sum = 0; 
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            sum = (sum + num) % M; 
            
            if(sum == 0) {
                result++;
            }
            
            cnt[(int)sum]++;
        }
        

        for(int i = 0; i < M; i++) {
            if(cnt[i] > 1) {
                result += (cnt[i] * (cnt[i] - 1)) / 2;
            }
        }
        
        System.out.println(result);
        br.close();
    }
}