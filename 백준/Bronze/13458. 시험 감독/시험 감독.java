import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        long totalSupervisors = 0; 
        
        for (int i = 0; i < N; i++) {
            totalSupervisors++;
            A[i] -= B;
            
            if (A[i] > 0) {
                totalSupervisors += A[i] / C; 
                
                if (A[i] % C != 0) {
                    totalSupervisors++;
                }
            }
        }
        
        System.out.println(totalSupervisors);
    }
}