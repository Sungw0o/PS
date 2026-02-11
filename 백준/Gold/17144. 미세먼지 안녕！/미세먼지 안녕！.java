import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	private static int R,C,T,dustCnt,dust,cleanerTop,cleanerBottom;
	
	private static boolean findCleaner;
	
	private static int[][] Room;
	
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	private static BufferedReader br;
	private static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		input();
		
		for(int time = 1; time <= T ; time++) {
			spread();
			airCleaner();
		}
		
		System.out.println(calcDust());
		br.close();
	}
	
	public static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		Room = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C ; j++) {
				Room[i][j] = Integer.parseInt(st.nextToken());
				if(Room[i][j] == -1 && !findCleaner) {
					cleanerTop = i;
					cleanerBottom = i+1;
					findCleaner = true;
				}
			}
		}
	}
	
	public static void spread() {
		
		int[][] temp = new int[R][C];
		
		for(int  i = 0; i < R ; i++) {
			for(int j = 0; j < C ; j++) {
				
				if(Room[i][j] == -1) {

					continue;
				}
				
				if(Room[i][j] > 0) {
				   int spreadCnt = 0;
				   dust = Room[i][j] / 5;
				   for(int k = 0; k < 4; k++) {
					   int nr = i+dr[k];
					   int nc = j+dc[k];
					   if(rangeCheck(nr,nc)) {
						   
						   temp[nr][nc] += dust;
						   spreadCnt++;
					   }
				   }
				   Room[i][j] -= dust * spreadCnt;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				Room[i][j] += temp[i][j];
			}
		}
	}
	
	public static boolean rangeCheck(int x, int y) {

		return x < R && x >= 0 && y < C && y >= 0 && Room[x][y] != -1; 
	}
	
	public static void airCleaner() {
		
		for (int i = cleanerTop - 1; i > 0; i--) {
            Room[i][0] = Room[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            Room[0][i] = Room[0][i + 1];
        }
        for (int i = 0; i < cleanerTop; i++) {
            Room[i][C - 1] = Room[i + 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            Room[cleanerTop][i] = Room[cleanerTop][i - 1];
        }
        
        Room[cleanerTop][1] = 0;

        
        for (int i = cleanerBottom + 1; i < R - 1; i++) {
            Room[i][0] = Room[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            Room[R - 1][i] = Room[R - 1][i + 1];
        }
        for (int i = R - 1; i > cleanerBottom; i--) {
            Room[i][C - 1] = Room[i - 1][C - 1];
        }
        for (int i = C - 1; i > 1; i--) {
            Room[cleanerBottom][i] = Room[cleanerBottom][i - 1];
        }
        
        Room[cleanerBottom][1] = 0;
	}
	
	public static int calcDust() {
		
		dustCnt = Arrays.stream(Room)
				.flatMapToInt(Arrays::stream)
				.sum();
		
		return dustCnt + 2;
		
	}
	
	
}
