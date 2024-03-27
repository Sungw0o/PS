import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                minCount = Math.min(minCount, countRepaint(board, i, j));
            }
        }
        
        System.out.println(minCount);
    }
    
    private static int countRepaint(char[][] board, int x, int y) {
        char startColor = board[x][y];
        int count = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i - x + j - y) % 2 == 0) {
                    if (board[i][j] != startColor)
                        count++;
                } else {
                    if (board[i][j] == startColor)
                        count++;
                }
            }
        }
        return Math.min(count, 64 - count); 
    }
}
