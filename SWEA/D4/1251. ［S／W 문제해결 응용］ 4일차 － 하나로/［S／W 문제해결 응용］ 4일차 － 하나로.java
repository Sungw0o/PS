
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    private static int T, N;
    private static double environFee;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            island[] islands = new island[N];
            for(int i = 0; i < N; i++) {
                islands[i] = new island(0, 0);
            }

            StringTokenizer stX = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i].x = Integer.parseInt(stX.nextToken());
            }

            StringTokenizer stY = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                islands[i].y = Integer.parseInt(stY.nextToken());
            }

            environFee = Double.parseDouble(br.readLine());

            boolean[] visited = new boolean[N];
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            pq.add(new Edge(0, 0L));

            long totalLengthSq = 0; 
            int connectCount = 0;  

            while (!pq.isEmpty()) {
                Edge current = pq.poll();

                if (visited[current.to]) continue;

                visited[current.to] = true;
                totalLengthSq += current.cost;
                connectCount++;

                if (connectCount == N) break;

                for (int i = 0; i < N; i++) {
                    if (!visited[i]) {
                        long distSq = getDistSquare(islands[current.to], islands[i]);
                        pq.add(new Edge(i, distSq));
                    }
                }
            }

            long ans = Math.round(environFee * totalLengthSq);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    public static long getDistSquare(island a, island b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy; 
    }

    public static class island {
        int x, y;

        public island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        int to;
        long cost; 

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost); 
        }
    }
}