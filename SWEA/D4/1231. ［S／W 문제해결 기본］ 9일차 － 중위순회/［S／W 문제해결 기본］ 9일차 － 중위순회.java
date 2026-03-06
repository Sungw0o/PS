import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    
    private static final int T = 10;
    private static int N;
    private static ArrayList<Integer>[] graph;
    private static char[] alpha; 
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            
            graph = new ArrayList[N + 1];
            alpha = new char[N + 1];
            
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                int nodeNum = Integer.parseInt(st.nextToken()); 
                alpha[nodeNum] = st.nextToken().charAt(0);     
                
                while (st.hasMoreTokens()) {
                    graph[nodeNum].add(Integer.parseInt(st.nextToken()));
                }
            }
            
            sb.append("#").append(t).append(" ");
            inorder(1); 
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
    
    private static void inorder(int node) {
        if (!graph[node].isEmpty()) {
            int leftChild = graph[node].get(0);
            inorder(leftChild); 
        }

        sb.append(alpha[node]);

        if (graph[node].size() > 1) {
            int rightChild = graph[node].get(1);
            inorder(rightChild); 
        }
    }
}