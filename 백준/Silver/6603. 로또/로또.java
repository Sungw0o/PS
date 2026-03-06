import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int k; 
    private static int[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break; 
            
            arr = new int[k];
            visited = new boolean[k]; 
            
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0, 0);
            
            System.out.println();
        }
    }
    
    public static void dfs(int idx, int depth) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (visited[i]) { 
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        

        for (int i = idx; i < k; i++) {
            visited[i] = true;          
            dfs(i + 1, depth + 1); 
            visited[i] = false;           
        }
    }
}