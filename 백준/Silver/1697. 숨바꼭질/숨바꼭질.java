import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int time = bfs(N);
        System.out.println(time);
        br.close();
    }

    static int bfs(int index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        visited[index] = 1; // 시작 위치 방문 처리

        while (!q.isEmpty()) {
            int d = q.poll();

            // 목표 위치에 도달한 경우
            if (d == K) {
                return visited[d] - 1; // 0초부터 시작하므로 -1
            }

            // d - 1
            if (d - 1 >= 0 && visited[d - 1] == 0) {
                visited[d - 1] = visited[d] + 1;
                q.add(d - 1);
            }

            // d + 1
            if (d + 1 <= 100000 && visited[d + 1] == 0) {
                visited[d + 1] = visited[d] + 1;
                q.add(d + 1);
            }

            // 2 * d
            if (2 * d <= 100000 && visited[2 * d] == 0) {
                visited[2 * d] = visited[d] + 1;
                q.add(2 * d);
            }
        }
        return -1; // 도달할 수 없는 경우
    }
}
