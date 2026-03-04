import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int N,R,Q;
	private static ArrayList<Integer>[] graph;
	private static int[] size;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		R= Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		size = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		
		for(int i = 1; i <= N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		countSubtree(R, -1);
		
		
		
		for(int i = 0; i < Q; i++) {
            int qNode = Integer.parseInt(br.readLine());
            sb.append(size[qNode]).append("\n");
        }
        
        System.out.println(sb);
        br.close();
	}
	
	public static void countSubtree(int current, int parent) {
        size[current] = 1; 
        
        for (int next : graph[current]) {
            if (next != parent) { 
                countSubtree(next, current);
                size[current] += size[next]; 
            }
        }
    }
}
