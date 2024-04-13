
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int max =0;
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(br.readLine());
            list.add(input);
            if(input>max)
                max = input;
        }
        int dp[] = new int[max+1];

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (Integer integer : list) {
            System.out.println(dp[integer]);
        }
    }
}
