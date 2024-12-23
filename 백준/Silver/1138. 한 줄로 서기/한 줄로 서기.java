import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); 

        int[] heights = new int[N]; 
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }

        int[] result = new int[N]; 

        for (int i = 0; i < N; i++) {
            int count = heights[i];
            int index = 0; 
            
            while (count > 0 || result[index] != 0) {
                if (result[index] == 0) { 
                    count--;
                }
                index++;
            }

            result[index] = i + 1; 
        }
        
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
        
        br.close();
    }
}
