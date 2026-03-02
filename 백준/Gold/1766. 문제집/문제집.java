import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N,M;

    private static ArrayList<Integer>[] graph;
    private static int[] indegree;

    private static PriorityQueue<Integer> q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int  cur = q.poll();
            sb.append(cur).append(" ");

            for(int next :graph[cur]){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
        br.close();
    }
}
