import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int[][] board = new int[9][9];
    static ArrayList<int[]> zeros = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                }
            }
        }
        
        solve(0);
    }

    static void solve(int idx) {
        if (idx == zeros.size()) {
            StringBuilder sb = new StringBuilder(); 
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        int r = zeros.get(idx)[0];
        int c = zeros.get(idx)[1];

        for (int i = 1; i <= 9; i++) {
            if (isValid(r, c, i)) {
                board[r][c] = i;
                solve(idx + 1);
                board[r][c] = 0;
            }
        }
    }

    static boolean isValid(int r, int c, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == val) return false;
            if (board[i][c] == val) return false;
        }
        
        int startRow = (r / 3) * 3;
        int startCol = (c / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) return false;
            }
        }
        
        return true;
    }
}