import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nm = line.split(" ");
        long n = Long.parseLong(nm[0]);
        long m = Long.parseLong(nm[1]);

        List<Edge>[] graph = new ArrayList[(int) (n + 1)];
        for (long i = 1; i <= n; i++) {
            graph[(int) i] = new ArrayList<>();
        }

        for (long i = 0; i < m; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            long a = Long.parseLong(edgeInfo[0]);
            long b = Long.parseLong(edgeInfo[1]);
            long signalTime = i;
            graph[(int) a].add(new Edge(b, signalTime));
            graph[(int) b].add(new Edge(a, signalTime));
        }

        long result = findMinTime(graph, n, m);
        System.out.println(result == Long.MAX_VALUE ? -1 : result);
        br.close();
    }

    public static long findMinTime(List<Edge>[] graph, long n, long m) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));
        long[] dist = new long[(int) (n + 1)];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        pq.offer(new long[]{1, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long curNode = cur[0];
            long curTime = cur[1];

            if (curNode == n) {
                return curTime;
            }

            if (curTime > dist[(int) curNode]) {
                continue;
            }

            for (Edge edge : graph[(int) curNode]) {
                long nextNode = edge.to;
                long signalTime = edge.signalTime;
                long waitTime = (curTime % m <= signalTime)
                        ? signalTime - (curTime % m)
                        : m - (curTime % m) + signalTime;
                long nextTime = curTime + waitTime + 1;

                if (nextTime < dist[(int) nextNode]) {
                    dist[(int) nextNode] = nextTime;
                    pq.offer(new long[]{nextNode, nextTime});
                }
            }
        }

        return Long.MAX_VALUE;
    }

    public static class Edge {
        long to, signalTime;

        public Edge(long to, long signalTime) {
            this.to = to;
            this.signalTime = signalTime;
        }
    }
}
