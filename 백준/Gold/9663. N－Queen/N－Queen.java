import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    private static int[] queens; 
    private static int count = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queens = new int[N]; 
        dfs(0);
        System.out.println(count);
        br.close();
    }

    static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col; 
                dfs(row + 1);    
            }
        }
    }
    
    static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) return false;
            
            if (Math.abs(row - i) == Math.abs(col - queens[i])) return false;
        }
        return true;
    }
}
