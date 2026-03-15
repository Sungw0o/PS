import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int V,E,nodeCnt;
    private static long mstCost;
    private static ArrayList<Node>[] graph;
    private static boolean[] visited;

    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        visited = new boolean[V+1];

        for(int i = 1; i < V+1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));

        }

        pq.add(new Node(1,0));
        mstCost = 0;
        nodeCnt = 0;


        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.to]) continue;

            visited[cur.to] = true;
            mstCost += cur.weight;
            nodeCnt++;

            if(nodeCnt == V) break;

            for(Node next : graph[cur.to]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
        }
        System.out.println(mstCost);
        br.close();
    }

    public static class Node implements Comparable<Node>{
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return Integer.compare(this.weight, n.weight);
        }
    }
}
