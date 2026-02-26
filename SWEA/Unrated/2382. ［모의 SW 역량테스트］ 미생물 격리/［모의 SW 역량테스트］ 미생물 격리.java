import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int T,N,M,K,sum;
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;
	
	private static int[] mx,my,mc,md;
	
	private static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t =1; t<= T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N][N];
			
			mx = new int[K];
			my = new int[K];
			mc = new int[K];
			md = new int[K];
			
			for(int i = 0; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				my[i] = Integer.parseInt(st.nextToken()); 
				mx[i] = Integer.parseInt(st.nextToken()); 
				mc[i] = Integer.parseInt(st.nextToken()); 
				md[i] = Integer.parseInt(st.nextToken()); 
			}
			
			move();
			sb.append("#").append(t+" ").append(cntCheck()).append("\n");
		}
		
		System.out.println(sb);
		br.close();

	}
	
	public static void move() {
		for(int m = 0; m < M ; m++) {
			for(int k = 0; k < K ; k++) {
				if (mc[k] == 0) continue;
				if(rangeCheck(mx[k],my[k])) {
					switch(md[k]) {
					case UP:
						my[k]--;
						break;
					case DOWN:
						my[k]++;
						break;
					case LEFT:
						mx[k]--;
						break;
					case RIGHT:
						mx[k]++;
						break;
					}
				}
				wallCheck(mx[k], my[k], k);
			}
			
			int[][] sumArr = new int[N][N];
            int[][] maxArr = new int[N][N];
            int[][] dirArr = new int[N][N];
            
            for (int k = 0; k < K; k++) {
                if (mc[k] == 0) continue;
                int x = mx[k];
                int y = my[k];
                
                sumArr[y][x] += mc[k];
                if (mc[k] > maxArr[y][x]) {
                    maxArr[y][x] = mc[k];
                    dirArr[y][x] = md[k];
                }
            }
            
            for (int k = 0; k < K; k++) {
                if (mc[k] == 0) continue;
                int x = mx[k];
                int y = my[k];
                
                if (sumArr[y][x] > 0) {
                    mc[k] = sumArr[y][x];
                    md[k] = dirArr[y][x];
                    sumArr[y][x] = 0;
                } else {
                    mc[k] = 0;
                }
            }
		}
	}
	
	public static boolean rangeCheck(int x, int y) {
		return x >= 0 && x < N && y >=0 && y < N;
	}
	
	public static void wallCheck(int x, int y,int idx) {
		
		if(x == 0 || y == 0 || x == N - 1 || y == N - 1) {
			mc[idx] = mc[idx] / 2;
			switch(md[idx]) {
			case UP:
				md[idx]++;
				break;
			case DOWN:
				md[idx]--;
				break;
			case LEFT:
				md[idx]++;
				break;
			case RIGHT:
				md[idx]--;
				break;
			}
		}
	}
	
	public static int cntCheck() {
		sum = 0;
		for(int i = 0; i < mc.length; i++) {
			sum += mc[i];
		}
		
		return sum;
	}
}
