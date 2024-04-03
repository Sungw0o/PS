
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int trimmean = Math.round((float) (n * 15) / 100);
        int sum =0; int count =0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int j=trimmean;j<n-trimmean;j++){
                sum += arr[j];
                count++;

        }
        sb.append(Math.round((float) sum /count));
        System.out.println(sb);

    }
}
