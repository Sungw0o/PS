import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int K, V, E;

    private static ArrayList<Integer>[] adj;
    private static int[] colors;
    private static boolean isBipartite;

    private static StringTokenizer st;
    private static StringBuilder sb;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        K = Integer.parseInt(br.readLine());

        for (int k = 1; k <= K; k++) {
            input();
            saveResult();
        }

        System.out.println(sb);
        br.close();
    }

    public static void input() throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        colors = new int[V + 1];

        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    public static boolean check() {
        isBipartite = true;

        for (int i = 0; i < V; i++) {
            if(!isBipartite) {
                break;
            }

            if(colors[i] == 0) {
                dfs(i,1);
            }
        }


        return isBipartite;
    }

    public static void saveResult() {
        String res = check() ? "YES" : "NO";
        sb.append(res).append("\n");
    }

    public static void dfs(int node, int color) {
        colors[node] = color;

        for (int next : adj[node]) {
            if(colors[next] == color) {
                isBipartite = false;
                return;
            }
            if(colors[next] == 0) {
                dfs(next, -color);
            }
        }

    }
}