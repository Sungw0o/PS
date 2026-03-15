import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N,E,edgeCnt;
    private static int[] parent;
    private static double[][] star;
    private static double starCost;

    private static PriorityQueue<starEdge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        E = N - 1;

        star = new double[N+1][2];
        parent = new int[N+1];

        for(int i = 1 ; i <= N; i++ ){
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            star[i][0] = x;
            star[i][1] = y;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1+1; j <= N; j++){
                double dist = getDistance(star[i][0],star[i][1],star[j][0],star[j][1]);
                pq.add(new starEdge(i,j,dist));
            }
        }

        starCost = 0;
        edgeCnt = 0;

        while(!pq.isEmpty()){

            starEdge cur  = pq.poll();
            if(union(cur.u,cur.v)){
                starCost += cur.weight;
                edgeCnt++;
                if(edgeCnt == E){
                    break;
                }
            }
        }

        System.out.printf("%.2f\n", starCost);
        br.close();

    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return false;
        parent[y] = x;
        return true;
    }

    public static double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static class starEdge implements Comparable<starEdge>{
        int u,v;
        double weight;

        public starEdge(int u,int v, double weight){
            this.v = v;
            this.u = u;
            this.weight = weight;
        }

        @Override
        public int compareTo(starEdge s){
            return Double.compare(this.weight,s.weight);
        }
    }
}
