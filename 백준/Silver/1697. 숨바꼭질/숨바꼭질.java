import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static Queue<Integer> queue = new LinkedList<>();
	private static int N, K;
	
	private static int[] map = new int[100001];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(N==K) {
			System.out.println(0);
			return;
		}
		
		int minT = bfs(N);
		System.out.println(minT);
		br.close();
		
	}
	
	public static int bfs(int n) {
		queue.add(n);
		map[n] = 1;
				
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			
			if(cur == K) {
				return map[cur] -1 ;
			}
			
			int[] nextMoves = {cur - 1, cur + 1, cur * 2};
			
			for (int next : nextMoves) {
				
				if (next >= 0 && next <= 100000 && map[next] == 0) {
					map[next] = map[cur] + 1; 
					queue.add(next);
				}
			}
		}				
		return -1;
	}
}