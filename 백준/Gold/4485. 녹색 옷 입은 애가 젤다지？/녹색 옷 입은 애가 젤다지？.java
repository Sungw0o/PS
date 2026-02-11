import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    private static int N;
    
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1}; 
    
    private static int[][] maze;
    private static int[][] dist;
    
    public static void main(String[] args) throws NumberFormatException, IOException {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problemIdx = 1;
        
        while(true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break; 
            
            N = Integer.parseInt(line);
            if(N == 0) break;
            
            init(N);
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dijkstra();
            
            sb.append("Problem ").append(problemIdx++).append(": ")
              .append(dist[N-1][N-1]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
    }
    
    public static void init(int n) {
        maze = new int[n][n];
        dist = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        dist[0][0] = maze[0][0];
        pq.offer(new Node(0, 0, maze[0][0]));
        
        while(!pq.isEmpty()) {
            Node current = pq.poll();
            
            if(dist[current.r][current.c] < current.cost) continue;
            
            for(int i = 0; i < 4; i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                
                if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    int nextCost = current.cost + maze[nr][nc];
                    
                    if(dist[nr][nc] > nextCost) {
                        dist[nr][nc] = nextCost;
                        pq.offer(new Node(nr, nc, nextCost));
                    }
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int r, c, cost;
        
        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}