import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static class Node implements Comparable<Node> {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] x = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }

            int[] y = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());

            boolean[] visited = new boolean[N];
            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.offer(new Node(0, 0));

            long totalWeight = 0;
            int nodeCount = 0;

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                if (visited[cur.to]) continue;

                visited[cur.to] = true;
                totalWeight += cur.weight;
                nodeCount++;

                if (nodeCount == N) break;

                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        long dist = getDist(x[cur.to], y[cur.to], x[i], y[i]);
                        pq.offer(new Node(i, dist));
                    }
                }
            }

            double result = totalWeight * E;
            sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    static long getDist(int x1, int y1, int x2, int y2) {
        return (long) Math.pow(x1 - x2, 2) + (long) Math.pow(y1 - y2, 2);
    }
}