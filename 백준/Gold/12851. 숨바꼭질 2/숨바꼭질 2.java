import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int K;
    static int[] visited = new int[100001];
    static int[] ways = new int[100001]; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int time = bfs(N);
        System.out.println(time);
        System.out.println(ways[K]); 
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1;
        ways[node] = 1; 

        while (!queue.isEmpty()) {
            int n = queue.poll();


            if (n == K) {
                continue;
            }


            for (int next : new int[]{n - 1, n + 1, n * 2}) {
                if (next >= 0 && next <= 100000) {

                    if (visited[next] == 0) {
                        visited[next] = visited[n] + 1;
                        ways[next] = ways[n];
                        queue.add(next);
                    } else if (visited[next] == visited[n] + 1) {

                        ways[next] += ways[n];
                    }
                }
            }
        }
        return visited[K] - 1; 
    }
}
