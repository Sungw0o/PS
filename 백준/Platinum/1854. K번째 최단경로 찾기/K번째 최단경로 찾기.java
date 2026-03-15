import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N,M,K;

    private static ArrayList<ArrayList<Node>> graph;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        PriorityQueue<Integer>[] distQueue = new PriorityQueue[N + 1];
        for (int i = 1; i <= N; i++) {
            distQueue[i] = new PriorityQueue<>(Collections.reverseOrder());
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }

        distQueue[1].add(0);
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node next : graph.get(cur.to)) {
                int nextCost = cur.cost + next.cost;

                if (distQueue[next.to].size() < K) {
                    distQueue[next.to].add(nextCost);
                    pq.add(new Node(next.to, nextCost));
                }
                else if (distQueue[next.to].peek() > nextCost) {
                    distQueue[next.to].poll();
                    distQueue[next.to].add(nextCost);
                    pq.add(new Node(next.to, nextCost));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distQueue[i].size() == K) {
                sb.append(distQueue[i].peek()).append("\n");
            } else {
                sb.append("-1\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static class Node implements Comparable<Node>{
        int to, cost;
        public Node( int to, int cost) {

            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
