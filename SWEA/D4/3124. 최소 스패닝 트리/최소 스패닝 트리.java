
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T,V,E,nodeCnt;
	
	private static long mstCost;
	
	private static boolean[] visited;
	private static ArrayList<Node>[] graph;
	private static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[V+1];
			visited = new boolean[V+1];
			
			for(int i = 1; i<=V; i++) {
				graph[i] = new ArrayList<>();
			}
			
			
			for(int i= 1; i <=E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				graph[u].add(new Node(v,w));
				graph[v].add(new Node(u,w));
			}
			
			pq.add(new Node(1,0));
			mstCost = 0;
			nodeCnt = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.to]) continue;
				
				visited[cur.to] = true;
				mstCost += cur.weight;
				nodeCnt++;
				
				if(nodeCnt == V) break;
				
				
				for(Node next : graph[cur.to]) {
					if(!visited[next.to]) {
						pq.add(next);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(mstCost).append("\n");
			
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static class Node implements Comparable<Node>{
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
