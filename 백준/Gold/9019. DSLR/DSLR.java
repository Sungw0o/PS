import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            boolean[] visited = new boolean[10000];
            int[] parent = new int[10000];
            char[] cmd = new char[10000];
            
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(A);
            visited[A] = true;
            
            while (!q.isEmpty()) {
                int curr = q.poll();
                
                if (curr == B) {
                    StringBuilder temp = new StringBuilder();
                    int idx = curr;
                    while (idx != A) {
                        temp.append(cmd[idx]);
                        idx = parent[idx];
                    }
                    sb.append(temp.reverse().toString()).append("\n");
                    break;
                }
                
                int d = (curr * 2) % 10000;
                if (!visited[d]) {
                    visited[d] = true;
                    parent[d] = curr;
                    cmd[d] = 'D';
                    q.offer(d);
                }
                
                int s = curr == 0 ? 9999 : curr - 1;
                if (!visited[s]) {
                    visited[s] = true;
                    parent[s] = curr;
                    cmd[s] = 'S';
                    q.offer(s);
                }
                
                int l = (curr % 1000) * 10 + curr / 1000;
                if (!visited[l]) {
                    visited[l] = true;
                    parent[l] = curr;
                    cmd[l] = 'L';
                    q.offer(l);
                }
                
                int r = (curr % 10) * 1000 + curr / 10;
                if (!visited[r]) {
                    visited[r] = true;
                    parent[r] = curr;
                    cmd[r] = 'R';
                    q.offer(r);
                }
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}