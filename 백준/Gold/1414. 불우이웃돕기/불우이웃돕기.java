import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] parent;

    static int charToLen(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a' + 1;
        if (c >= 'A' && c <= 'Z') return c - 'A' + 27;
        return 0;
    }

    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        List<int[]> edges = new ArrayList<>();
        int total = 0;

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                int len = charToLen(line.charAt(j - 1));
                total += len;
                if (i != j && len > 0) edges.add(new int[]{len, i, j});
            }
        }

        edges.sort(Comparator.comparingInt(a -> a[0]));

        int mst = 0, cnt = 0;
        for (int[] e : edges) {
            if (union(e[1], e[2])) {
                mst += e[0];
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        System.out.println(cnt == N - 1 ? total - mst : -1);
    }
}

