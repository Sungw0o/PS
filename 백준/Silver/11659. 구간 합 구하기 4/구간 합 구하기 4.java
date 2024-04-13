import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] arr = new int[n];
        int[] prefixSum = new int[n + 1]; 
        String[] num = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(num[i]);
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        for(int k = 0; k < m; k++){
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]) - 1; 
            int j = Integer.parseInt(ij[1]) - 1; 
            int sum = prefixSum[j + 1] - prefixSum[i]; 
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
