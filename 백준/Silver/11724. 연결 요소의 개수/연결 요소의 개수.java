import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        cc = 0;

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                cc++;
            }
        }
        sb.append(cc);
        System.out.println(sb);

        br.close();
    }

    public static void dfs(int u){
        visited[u] = true;
        for(int v : graph[u]){
            if(!visited[v]){
                dfs(v);
            }
        }
    }
}
