import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 
        int[] tall = new int[N+1]; 
        ArrayList<Integer> ans = new ArrayList<>(); 

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            tall[i] = Integer.parseInt(input[i - 1]);
        }
        
        for (int i = N; i >= 1; i--) {
            ans.add(tall[i], i); 
        }

        for (int k : ans) {
            System.out.print(k + " ");
        }

        br.close(); 
    }
}
