import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int V,E,X;
    private static ArrayList<ArrayList<Node>> graph;
    private static ArrayList<ArrayList<Node>> reverseGraph;
    private static int[] dist,dist2;

    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
            reverseGraph.get(to).add(new Node(from, cost));
        }

        dist = new int[V+1];
        dist2 = new int[V+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        dist[X] = 0;
        dist2[X] = 0;



        pq.add(new Node(X,0));

        while (!pq.isEmpty()) {

            Node cur  = pq.poll();

            if(dist[cur.to] < cur.cost) {
                continue;
            }

            for(Node next : graph.get(cur.to)) {
                if(dist[next.to] > dist[cur.to] + next.cost) {
                    dist[next.to] = dist[cur.to] + next.cost;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        pq.add(new Node(X,0));

        while (!pq.isEmpty()) {

            Node cur  = pq.poll();

            if(dist2[cur.to] < cur.cost) {
                continue;
            }

            for(Node next : reverseGraph.get(cur.to)) {
                if(dist2[next.to] > dist2[cur.to] + next.cost) {
                    dist2[next.to] = dist2[cur.to] + next.cost;
                    pq.add(new Node(next.to, dist2[next.to]));
                }
            }
        }

        int sum = Integer.MIN_VALUE;

        for(int i = 1; i <= V; i++){
            sum = Math.max(sum, dist[i] + dist2[i]);
        }

        System.out.println(sum);
        br.close();
    }

    public static class Node implements Comparable<Node>{

        int to,cost;

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
