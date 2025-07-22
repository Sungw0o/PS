import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M;
    private static boolean[] visited;
    private static int[] result;

    public static void main(String[] args) throws IOException {
      
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];  
        result = new int[M];         

        dfs(0);
        br.close();
    }

  
    static void dfs(int depth) {
        
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;      
                result[depth] = i;      
                dfs(depth + 1);         
                visited[i] = false;     
            }
        }
    }
}
