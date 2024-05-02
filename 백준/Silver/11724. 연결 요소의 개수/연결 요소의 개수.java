import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int n = Integer.parseInt(NM[0]);
        int m = Integer.parseInt(NM[1]);
        nodeList = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            String[] UV = br.readLine().split(" ");
            int u = Integer.parseInt(UV[0]);
            int v = Integer.parseInt(UV[1]);
            nodeList[u].add(v);
            nodeList[v].add(u);
        }
        int num = getConnectedComponent(n,nodeList);
        System.out.println(num);
    }
    static int getConnectedComponent(int N, ArrayList<Integer>[] g) {
        nodeList = g;
        visited = new boolean[N + 1];
        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
                ans++;
            }
        }
        return ans;
    }


    static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int next : nodeList[node]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }


}
