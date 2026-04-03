import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        map = new char[n][n * 2 - 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                map[i][j] = ' ';
            }
        }
        
        drawStar(0, n - 1, n);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]).append('\n');
        }
        System.out.print(sb);
    }

    static void drawStar(int r, int c, int n) {
        if (n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
            return;
        }

        int nextSize = n / 2;
        drawStar(r, c, nextSize);
        drawStar(r + nextSize, c - nextSize, nextSize);
        drawStar(r + nextSize, c + nextSize, nextSize);
    }
}