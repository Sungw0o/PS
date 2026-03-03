
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	private static int V,E;
	private static ArrayList<Integer>[] graph;
	private static int[] indegree;
	
	private static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = 10;
		for(int t = 1; t <= T; t++) {
			
			sb.append("#"+t+" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			indegree = new int[V+1];
			
			for(int i = 1; i <= V ; i++) {
				graph[i] = new ArrayList<>();
			}
			
			q.clear();
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1; i <= E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b);
				indegree[b]++;
			}
			
		
			
			for(int i= 1 ; i <= V; i++) {
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
			
			while(!q.isEmpty()) {
				
				int cur = q.poll();
				
				sb.append(cur+" ");
				
				for(int next : graph[cur]) {
					indegree[next]--;
					
					if(indegree[next] ==0) {
						q.offer(next);
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
