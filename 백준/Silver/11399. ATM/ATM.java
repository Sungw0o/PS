

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] timeStr = br.readLine().split(" ");
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(timeStr[i]);
        }
        Arrays.sort(time);
        int sum = 0;
        int waitingTime = 0;
        for (int i = 0; i < n; i++) {
            waitingTime += time[i];
            sum += waitingTime; 
        }
        System.out.println(sum);
    }
}
