import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] matrixA, matrixB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        matrixA = new int[n][m];
        matrixB = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = line.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrixB[i][j] = line.charAt(j) - '0';
            }
        }
        
        int count = 0;
        
        if (n >= 3 && m >= 3) {
            for (int i = 0; i < n - 2; i++) {
                for (int j = 0; j < m - 2; j++) {
                    if (matrixA[i][j] != matrixB[i][j]) {
                        flip(i, j);
                        count++;
                    }
                }
            }
        }
        
        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrixA[i][j] != matrixB[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }
        
        if (isSame) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
    
    private static void flip(int r, int c) {
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                matrixA[i][j] = 1 - matrixA[i][j];
            }
        }
    }
}