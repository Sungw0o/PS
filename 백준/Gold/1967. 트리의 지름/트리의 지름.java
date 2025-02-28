import java.io.*;
import java.util.*;

public class Main {
    static int N, maxDistance, farthestNode;
    static List<Node>[] tree;
    static boolean[] visited;

    static class Node {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            return;
        }

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        
        visited = new boolean[N + 1];
        maxDistance = 0;
        dfs(1, 0);
        
        visited = new boolean[N + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
        br.close();
    }

    static void dfs(int node, int distance) {
        visited[node] = true;

        if (distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node neighbor : tree[node]) {
            if (!visited[neighbor.vertex]) {
                dfs(neighbor.vertex, distance + neighbor.weight);
            }
        }
    }
}

