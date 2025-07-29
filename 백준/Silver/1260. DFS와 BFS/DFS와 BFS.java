import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<Integer>[] graph;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);
        br.close();

    }
    public static void dfs(int node) {
        if(visited[node]){
            return;
        }

        visited[node] = true;
        sb.append(node).append(" ");

        for(int n : graph[node]){
            if(!visited[n]){
                dfs(n);
            }
        }
    }
    public static void bfs(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for(int n : graph[cur]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }
}
