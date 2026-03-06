import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static ArrayList<Integer>[] tree;
    private static int[] praise;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[N + 1];
        praise = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int superior = Integer.parseInt(st.nextToken());
            if (superior != -1) {
                tree[superior].add(i);
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int staffNum = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            
            praise[staffNum] += p; 
        }
        
        dfs(1);
       
        for (int i = 1; i <= N; i++) {
            sb.append(praise[i]).append(" ");
        }
        
        System.out.println(sb);
    }
    
    private static void dfs(int node) {
        for (int child : tree[node]) {
            praise[child] += praise[node];
            dfs(child); 
        }
    }
}