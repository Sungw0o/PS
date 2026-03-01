import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M,V;

    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);

        System.out.println(sb);
        sb.setLength(0);

        visited = new boolean[N+1];
        bfs(V);
        System.out.println(sb);

        br.close();

    }

    public static void dfs(int num){

        visited[num] = true;
        sb.append(num).append(" ");

        for(int i :  graph[num]){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int num){
        Queue<Integer> q = new LinkedList<>();

        q.add(num);

        visited[num] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i :  graph[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
