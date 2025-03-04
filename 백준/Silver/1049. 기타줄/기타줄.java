import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 

        int minSetPrice = Integer.MAX_VALUE;
        int minSinglePrice = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int setPrice = Integer.parseInt(st.nextToken());
            int singlePrice = Integer.parseInt(st.nextToken());

            minSetPrice = Math.min(minSetPrice, setPrice);
            minSinglePrice = Math.min(minSinglePrice, singlePrice);
        }

        
        int cost1 = ((N / 6) + 1) * minSetPrice;
        int cost2 = (N / 6) * minSetPrice + (N % 6) * minSinglePrice;
        int cost3 = N * minSinglePrice;
        
        int minCost = Math.min(cost1, Math.min(cost2, cost3));
        System.out.println(minCost);
        br.close();
    }
}