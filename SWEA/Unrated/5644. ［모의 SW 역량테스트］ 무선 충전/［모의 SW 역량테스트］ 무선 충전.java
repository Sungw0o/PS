import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static final int[] dy = {0, -1, 0, 1, 0}; 
	private static final int[] dx = {0, 0, 1, 0, -1};
	
	private static int T, M, A, totalCharge;
	
	private static int[] aCourse;
	private static int[] bCourse;
	
	private static int[] apX; 
	private static int[] apY; 
	private static int[] apC; 
	private static int[] apP; 
	
	private static BufferedReader br;
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		if(line == null) return;
		T = Integer.parseInt(line.trim());
		
		for(int t = 1; t <= T; t++) {
			init();   
			solve();  
			sb.append("#").append(t).append(" ").append(totalCharge).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	public static void solve() {
		
		int ax = 1, ay = 1;
		int bx = 10, by = 10;
		

		charge(ax, ay, bx, by); 
		
		for(int i = 0; i < M; i++) {
			ay += dy[aCourse[i]];
			ax += dx[aCourse[i]];
			
			by += dy[bCourse[i]];
			bx += dx[bCourse[i]];
			
			charge(ax, ay, bx, by);
		}
	}
	
	public static void charge(int ax, int ay, int bx, int by) {
		int max = 0;

		for(int i = 0; i < A; i++) {
			for(int j = 0; j < A; j++) {
				int sum = 0;
				
				int amountA = check(i, ax, ay);
				int amountB = check(j, bx, by);
				
				if(i != j) {
					sum = amountA + amountB;
				} 
				else {

					sum = Math.max(amountA, amountB); 
				}
				
				if(sum > max) {
					max = sum;
				}
			}
		}
		totalCharge += max;
	}
	
	public static int check(int bcIndex, int x, int y) {
		int dist = Math.abs(apX[bcIndex] - x) + Math.abs(apY[bcIndex] - y);
		
		if(dist <= apC[bcIndex]) {
			return apP[bcIndex];
		}
		return 0;
	}

	public static void init() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		
		aCourse = new int[M];
		bCourse = new int[M];
		
		apX = new int[A];
		apY = new int[A];
		apC = new int[A];
		apP = new int[A];
		
		totalCharge = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< M ;i++) {
			aCourse[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< M ;i++) {
			bCourse[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i< A ; i++) {
			st = new StringTokenizer(br.readLine());
			apX[i] = Integer.parseInt(st.nextToken()); 
			apY[i] = Integer.parseInt(st.nextToken()); 
			apC[i] = Integer.parseInt(st.nextToken());
			apP[i] = Integer.parseInt(st.nextToken());
		}
	}
}