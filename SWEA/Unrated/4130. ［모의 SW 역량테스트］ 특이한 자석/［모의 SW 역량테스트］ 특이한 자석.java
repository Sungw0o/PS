import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T, K, score,magNum,dir;
	private static Magnet[] magBoard;
	
	private static final int N = 0;
	private static final int S = 1;
	private static final int poleCnt = 8;
	private static final int clockwise = 1;
	private static final int unclockwise = -1;
	
	private static StringTokenizer st;
	private static StringBuilder sb = new StringBuilder();
		
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i<= T; i++) {
			
			K = Integer.parseInt(br.readLine());
			magBoard = new Magnet[4];
			score = 0;
			
			for(int j = 0; j < 4 ; j ++) {
				magBoard[j] = new Magnet(j, new int[poleCnt]);
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < poleCnt; k++) {
					magBoard[j].poles[k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				magNum = Integer.parseInt(st.nextToken()) -1;
				dir = Integer.parseInt(st.nextToken());
				rotate(magNum,dir);
			}
			
			calcScore();
			
			sb.append("#"+i+" ").append(score).append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static void rotate(int magnum, int dir) {
		
		int[] rotateDirs = new int[4];
		rotateDirs[magnum] = dir;
		
		for(int i = magnum -1; i>=0; i--) {
			int rightIdx = i + 1;
			
			if(magBoard[i].poles[2] != magBoard[rightIdx].poles[6]) {
				rotateDirs[i] = -rotateDirs[rightIdx];
			} else {
				break;
			}
		}
		
		for(int i = magnum + 1; i < 4; i++) {
			int leftIdx = i - 1;
			
			if(magBoard[i].poles[6] != magBoard[leftIdx].poles[2]) {
				rotateDirs[i] = -rotateDirs[leftIdx];
			} else {
				break;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(rotateDirs[i] != 0) {
				doRotation(i, rotateDirs[i]);
			}
		}
	}
	
	public static void doRotation(int idx, int d) {
		int[] poles = magBoard[idx].poles;
		
		if(d == clockwise) { 
			int temp = poles[7];
			for(int i = 7; i > 0; i--) {
				poles[i] = poles[i-1];
			}
			poles[0] = temp;
		} 
		
		else if (d == unclockwise){ 
			int temp = poles[0];
			for(int i = 0; i < 7; i++) {
				poles[i] = poles[i+1];
			}
			poles[7] = temp;
		}
	}

	public static void calcScore() {
		
		if(magBoard[0].poles[0] == 1) score += 1;
		if(magBoard[1].poles[0] == 1) score += 2;
		if(magBoard[2].poles[0] == 1) score += 4;
		if(magBoard[3].poles[0] == 1) score += 8;
		
	}

	public static class Magnet{
		
		int num;
		int[] poles;
		
		public Magnet(int num, int[] poles) {

			this.num = num;
			this.poles = poles;
		}
	}
}
