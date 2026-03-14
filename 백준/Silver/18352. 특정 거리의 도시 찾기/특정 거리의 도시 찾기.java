import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N,M,K,X;

    private static int[] dist;
    private static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        dist = new int[N+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,1));
        }

        bfs(X);


        int cnt = 0;
        for(int i = 1; i <= N; i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
                cnt++;
            }
        }

        if(cnt == 0){
            sb.append("-1");
        }

        System.out.println(sb);
    }

    public static void bfs(int s){
        PriorityQueue<Node> q = new PriorityQueue<>();

        q.add(new Node(s,0));
        dist[s] = 0;


        while(!q.isEmpty()){
            Node cur = q.poll();

            if(dist[cur.to] < cur.cost){
                continue;
            }


            for(Node next : graph.get(cur.to)){

                if(dist[next.to] > dist[cur.to] + next.cost){
                    dist[next.to] = dist[cur.to] + next.cost;
                    q.add(new  Node(next.to, dist[next.to]));
                }
            }
        }


    }

    public static class Node implements Comparable<Node>{
        int to;
        int cost;
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
