import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N;
    private static ArrayList<Integer>[] graph;
    private static int[] indegree;
    private static int[] time;
    private static int[] resTime;
    private static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        indegree = new int[N+1];
        time = new int[N+1];
        resTime = new int[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int degreeCnt = Integer.parseInt(st.nextToken());
            if(degreeCnt == 0) continue;

            indegree[i] = degreeCnt;
            for (int j = 0; j < degreeCnt; j++) {
                int node = Integer.parseInt(st.nextToken());
                graph[node].add(i);
            }

        }

        for(int i = 1; i <= N; i++){
            resTime[i] = time[i];
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int node : graph[cur]){
                indegree[node]--;
                resTime[node] = Math.max(resTime[node], resTime[cur] + time[node]);
                if(indegree[node] == 0){
                   
                    q.add(node);
                }
            }
        }

        Arrays.sort(resTime);

        System.out.println(resTime[N]);
        br.close();
    }
}
