import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] cities;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        cities = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            cities[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    cities[i].add(j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] travelplan = new int[M];
        for (int i = 0; i < M; i++) {
            travelplan[i] = Integer.parseInt(st.nextToken());
        }

        dfs(travelplan[0]);

        boolean possible = true;
        for (int city : travelplan) {
            if (!visited[city]) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
        br.close();
    }


    private static void dfs(int city) {
        visited[city] = true;
        for (int nextCity : cities[city]) {
            if (!visited[nextCity]) {
                dfs(nextCity);
            }
        }
    }
}
