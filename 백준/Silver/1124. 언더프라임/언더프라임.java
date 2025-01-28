import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for( int i = A; i <= B; i++){
            int primeCnt = 0;
            int temp = i;
            for(int j = 2; j <= Math.sqrt(i); j++){

                while(temp % j == 0){
                    primeCnt++;
                    temp /= j;
                }
            }

            if(temp > 1) {
                primeCnt++;
            }

            if(isPrime(primeCnt)){
                cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }

    public static boolean isPrime(int num){
        
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}
