import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static ArrayList<Integer>[] arr;
    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        dfs(1,0);

        for(int i = 2; i<= N;i++){
            sb.append(parent[i]+"\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void dfs(int cur, int prev){
        parent[cur] = prev;

        for (int nxt : arr[cur]) {
            if(nxt == prev) continue;
            dfs(nxt, cur);
        }
    }
}
