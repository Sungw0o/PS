import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> set = new TreeSet<>();
        int[] diffs = new int[100001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            set.add(new Problem(p, l));
            diffs[p] = l;
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                set.add(new Problem(p, l));
                diffs[p] = l;
            } else if (cmd.equals("solved")) {
                int p = Integer.parseInt(st.nextToken());
                set.remove(new Problem(p, diffs[p]));
                diffs[p] = 0;
            } else if (cmd.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(set.last().num).append("\n");
                } else {
                    sb.append(set.first().num).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }

    public static class Problem implements Comparable<Problem> {
        int num, diff;

        public Problem(int num, int diff) {
            this.num = num;
            this.diff = diff;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.diff == o.diff) {
                return this.num - o.num;
            }
            return this.diff - o.diff;
        }
    }
}