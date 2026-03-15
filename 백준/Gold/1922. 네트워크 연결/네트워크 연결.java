import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N,M,edgeCnt;

    private static long mstCount;

    private static int[] parent;

    private static PriorityQueue<Edge>[] pq = new PriorityQueue[N+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Edge[] e = new Edge[M];
        parent = new int[N+1];

        makeSet(N);

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            e[i] = new Edge(from, to, cost);
        }

        Arrays.sort(e);

        mstCount = 0;
        edgeCnt = 0;

        for(Edge edge : e){
            if(union(edge.u, edge.v)){
                mstCount += edge.cost;
                edgeCnt++;

                if(edgeCnt == N-1) break;
            }
        }

        System.out.println(mstCount);
    }

    public static class Edge implements Comparable<Edge>{

        int u,v,cost;
        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void makeSet(int n){

        parent = new int[n+1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
    }

    public static boolean union(int a, int b){

        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB){
            return false;
        }

        parent[rootB] = rootA;
        return true;
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = find(parent[a]);

    }
}
