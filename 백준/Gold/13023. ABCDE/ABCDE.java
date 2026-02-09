import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] adj;
    static int[] adjSize;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new int[N][N];
        adjSize = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a][adjSize[a]++] = b;
            adj[b][adjSize[b]++] = a;
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;

            if (found) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void dfs(int now, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        for (int i = 0; i < adjSize[now]; i++) {
            int next = adj[now][i];

            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
                visited[next] = false;

                if (found) return;
            }
        }
    }
}
