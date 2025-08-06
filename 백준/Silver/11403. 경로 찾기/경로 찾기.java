import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] graph;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i, result);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }


    static void dfs(int start, int node, int[][] result) {
        for (int next = 0; next < N; next++) {
            if (graph[node][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1; 
                dfs(start, next, result);
            }
        }
    }
}
