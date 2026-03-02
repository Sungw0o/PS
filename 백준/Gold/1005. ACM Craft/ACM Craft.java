import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int T,N,K,W;

    private static ArrayList<Integer>[] graph;
    private static int[] indegree;
    private static int[] buildTime;
    private static int[] resultTime;

    private static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N+1];
            indegree = new int[N+1];
            buildTime = new int[N+1];
            resultTime = new int[N+1];

            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<= N;j++){
                graph[j] = new ArrayList<>();
                buildTime[j] = Integer.parseInt(st.nextToken());
                resultTime[j] = buildTime[j];
            }

            for(int k = 1; k<= K; k++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                indegree[b]++;
            }

            W = Integer.parseInt(br.readLine());

            for(int n = 1; n<= N; n++){
                if(indegree[n] == 0){
                    q.add(n);
                }
            }

            while(!q.isEmpty()){
                int cur = q.poll();

                for(int next : graph[cur]){
                    resultTime[next] = Math.max(resultTime[next], resultTime[cur] + buildTime[next]);
                    indegree[next]--;

                    if(indegree[next] == 0){
                        q.add(next);
                    }
                }
            }

            sb.append(resultTime[W]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
