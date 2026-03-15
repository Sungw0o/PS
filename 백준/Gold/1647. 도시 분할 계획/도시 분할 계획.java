import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N,M,nodeCnt;
    private static long mstCost,maxCost;

    private static boolean[] visited;

    private static ArrayList<Node>[] graph;

    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        mstCost = 0;
        maxCost = 0;
        nodeCnt = 0;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,cost));
            graph[v].add(new Node(u,cost));
        }

        pq.add(new Node(1,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(visited[cur.to]) continue;

            visited[cur.to] = true;
            mstCost += cur.cost;
            maxCost = Math.max(cur.cost,maxCost);
            nodeCnt++;

            if(nodeCnt == N){ break;}

            for(Node next : graph[cur.to]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }

        System.out.println(mstCost-maxCost);
    }

    public static class Node implements Comparable<Node>{

        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
