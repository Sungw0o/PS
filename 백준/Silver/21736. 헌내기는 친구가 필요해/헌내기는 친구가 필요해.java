import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N,M,cnt,srtX,srtY;
	
	private static char[][] arr;
	private static boolean[][] visited;
	
	private static final int[] dr = {-1,1,0,0};
	private static final int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N][M];
		visited = new boolean[N][M];
		cnt = 0;
		
		for(int i = 0; i < N; i++) {
		    String input = br.readLine();
		    for(int j = 0; j < M; j++) {
		    	arr[i][j] = input.charAt(j);
		    	
		    	if(arr[i][j] == 'I') {
		    		srtX = i;
		    		srtY = j;
		    	}
		    }
		}
		
		dfs(srtX,srtY);
		if(cnt == 0) {
			System.out.println("TT");
			return;
		}
		System.out.println(cnt);
		br.close();
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		
		if(arr[x][y] == 'P') {
			cnt++;
		}
		
		for(int i = 0; i < 4; i++) {
			int r = x + dr[i];
			int c = y + dc[i];
			if(rangeCheck(r,c)) {
				if(valueCheck(r,c)) {
					dfs(r,c);
				}
			}
		}
	}
	
	public static boolean rangeCheck(int x,int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	public static boolean valueCheck(int x, int y) {
		return arr[x][y] != 'X' && !visited[x][y];
	}
}
