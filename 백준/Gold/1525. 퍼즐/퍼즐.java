import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dxy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String target = "123456780"; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder initial = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                initial.append(st.nextToken());
            }
        }

        System.out.println(bfs(initial.toString()));
    }

    static int bfs(String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                String current = queue.poll();
                if (current.equals(target)) return moves;

                int zeroIndex = current.indexOf('0');
                int x = zeroIndex / 3, y = zeroIndex % 3;

                for (int[] dir : dxy) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        char[] nextState = current.toCharArray();
                        nextState[zeroIndex] = nextState[nx * 3 + ny];
                        nextState[nx * 3 + ny] = '0';
                        String next = new String(nextState);

                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
