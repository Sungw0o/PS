import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T,V,E;
	
	private static int[] parent;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			Edge[] edges = new Edge[E];
			
			for(int i= 0; i <E ; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(u,v,w);
			}
			
			
			Arrays.sort(edges);
			
			parent = new int[V+1];
			
			for(int i= 0; i <= V; i++) {
				parent[i] = i;
			}
			
			
			long mstCost = 0;
			int edgeCount = 0;
			
			for(Edge edge : edges) {
				if(union(edge.u,edge.v)) {
					mstCost += edge.weight;
					edgeCount++;
					if(edgeCount == V -1) break;
				}
			}
			
			sb.append("#").append(t).append(" ").append(mstCost).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int find(int x) {
		if(parent[x]== x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return false;
		
		parent[y] = x;
		
		return true;
	}
	
	
	public static class Edge implements Comparable<Edge>{
		int u, v, weight;
		
		public Edge(int u,int v,int weight) {
			this.u = u;
			this.v= v;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	
}
