import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static int[] budget;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        
        Arrays.sort(budget);

        System.out.println(binarySearch(budget));

        br.close();

    }

    static int binarySearch(int[] budget){
        int left =0;
        int right = budget[N-1];
        int maxBudget =0;

        while(left<=right){
            int mid = (left+right)/2;
            int total =0;

            for(int b : budget){
                if(b > mid){
                    total += mid;
                }
                else {
                    total += b;
                }
            }
            if(total <= M){
                maxBudget =mid;
                left = mid + 1;
            }
            else {
                right = mid -1;
            }
        }
        return maxBudget;

    }
}
