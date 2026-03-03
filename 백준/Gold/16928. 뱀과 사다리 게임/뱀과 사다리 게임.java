import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] board = new int[101];
    private static int[] dist = new int[101];  

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            board[u] = v;
        }

        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        dist[start] = 0; 

        

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(dist[cur]);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100) continue;

                if (board[next] != 0) {
                    next = board[next];
                }

                if (dist[next] == 0 && next != 1) { 
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}