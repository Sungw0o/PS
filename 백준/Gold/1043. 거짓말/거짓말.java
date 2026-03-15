import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeSet(N);

        st = new StringTokenizer(br.readLine());

        int tNum = Integer.parseInt(st.nextToken());

        if (tNum == 0) {
            System.out.println(M);
            return;
        }

        int[] truth = new int[tNum];
        for (int i = 0; i < tNum; i++) {
            truth[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] parties = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            if (num > 0) {
                int first = Integer.parseInt(st.nextToken());
                parties[i].add(first);

                for (int j = 1; j < num; j++) {
                    int p = Integer.parseInt(st.nextToken());
                    parties[i].add(p);
                    union(first, p);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            boolean canLie = true;

            if (parties[i].size() > 0) {
                int partyRep = parties[i].get(0);

                for (int j = 0; j < tNum; j++) {
                    if (find(partyRep) == find(truth[j])) {
                        canLie = false;
                        break;
                    }
                }
            }

            if (canLie) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void makeSet(int n) {
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public static boolean union(int a, int b) {
        int rA = find(a);
        int rB = find(b);

        if (rA == rB)
            return false;

        parent[rB] = rA;

        return true;
    }
}