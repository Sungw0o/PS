import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	private static final char road = '.';
	private static final char wall = '#';
	private static final char forward = 'F';
	private static final char turnL = 'L';
	private static final char turnR = 'R';
	
	private static char[] input;
	
	private static int[] dr = {1, 0, -1, 0};
	private static int[] dc = {0, -1, 0, 1};
	
	private static char[][] maze = new char[101][101];
	
	public static void main(String[] args) throws Throwable, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
	    input = br.readLine().toCharArray();
	    
	    for(int i=0; i<101; i++) {
			Arrays.fill(maze[i], wall);
		}
	    
	    int r = 50;
    	int c = 50;
    	int dir = 0;
    	
    	maze[r][c] = road;
    	
    	int minR = 50, maxR = 50;
		int minC = 50, maxC = 50;
	    
	    for(char ch : input) {
	    	if(ch == forward) {
	    		r += dr[dir];
	    		c += dc[dir];
	    		maze[r][c] = road;
	    		
	    		minR = Math.min(minR, r);
	    		maxR = Math.max(maxR, r);
	    		minC = Math.min(minC, c);
	    		maxC = Math.max(maxC, c);
	    		
	    	} 
	    	else if (ch == turnL) {
	    		dir = (dir + 3) % 4;
	    	} 
	    	else if (ch == turnR) {
	    		dir = (dir + 1) % 4;
	    	}
	    }
	    
	    for(int i = minR; i <= maxR; i++) {
	    	for(int j = minC; j <= maxC; j++) {
	    		sb.append(maze[i][j]);
	    	}
	    	sb.append("\n");
	    }
	    
	    bw.write(sb.toString());
	    bw.flush();
	    bw.close();
	    br.close();
	}
}