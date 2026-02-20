import java.io.*;
import java.util.*;

public class Solution {

    private static int V, E;
    private static final int T = 10;

    private static List<List<Integer>> arr = new ArrayList<>();
    private static int[] indegree;

    private static Queue<Integer> q = new LinkedList<>();

    private static BufferedReader br;
    private static StringTokenizer st;
    private static StringBuilder sb;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            init();
            input();
            sort();

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        indegree = new int[V + 1];

        arr.clear();
        for (int i = 0; i <= V; i++) {
            arr.add(new ArrayList<>());
        }

        q.clear();
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < E; i++) {
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            arr.get(c1).add(c2);
            indegree[c2]++;
        }
    }

    public static void sort() {
        for (int i = 1; i <= V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for (Integer i : arr.get(cur)) {
                indegree[i]--;

                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
        }
    }
}