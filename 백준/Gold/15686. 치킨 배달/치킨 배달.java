import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int N, M;
	private static int minChickenDistance = Integer.MAX_VALUE;
	
	private static final int HOUSE = 1;
	private static final int CHICKEN_RES = 2;
	
	private static ArrayList<Point> houseRC = new ArrayList<>();
	private static ArrayList<Point> chickenResRC = new ArrayList<>();
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());
				if(value == CHICKEN_RES) {
					chickenResRC.add(new Point(i, j));
				} else if(value == HOUSE) {
					houseRC.add(new Point(i, j));
				}
			}
		}
		
		visited = new boolean[chickenResRC.size()];
		
		dfs(0, 0);
		
		System.out.println(minChickenDistance);
		br.close();
	}
	
	public static void dfs(int start, int cnt) {
		if(cnt == M) {
			calculateDistance();
			return;
		}
		
		for(int i = start; i < chickenResRC.size(); i++) {
			visited[i] = true;
			dfs(i + 1, cnt + 1);
			visited[i] = false;
		}
	}
	
	public static void calculateDistance() {
		int totalDistance = 0;
		
		for(Point h : houseRC) {
			int minDis = Integer.MAX_VALUE;
			
			for(int i = 0; i < chickenResRC.size(); i++) {
				if(visited[i]) {
					Point c = chickenResRC.get(i);
					int dist = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
					minDis = Math.min(minDis, dist);
				}
			}
			totalDistance += minDis;
		}
		
		minChickenDistance = Math.min(minChickenDistance, totalDistance);
	}
	
	public static class Point {
		int r;
		int c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}