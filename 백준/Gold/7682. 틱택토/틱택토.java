import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            char[] board = input.toCharArray();
            sb.append(validation(board) ? "valid" : "invalid").append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static boolean validation(char[] board) {
        int xCnt = 0;
        int oCnt = 0;

        for (char c : board) {
            if (c == 'X') xCnt++;
            if (c == 'O') oCnt++;
        }

        if (xCnt != oCnt && xCnt != oCnt + 1) {
            return false;
        }

        boolean xWin = checkWin(board, 'X');
        boolean oWin = checkWin(board, 'O');

        if (xWin && oWin) {
            return false;
        }

        if (xWin && xCnt != oCnt + 1) {
            return false;
        }

        if (oWin && xCnt != oCnt) {
            return false;
        }

        if (!xWin && !oWin && xCnt + oCnt < 9) {
            return false;
        }

        return true;
    }

    public static boolean checkWin(char[] board, char player) {
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player) {
                return true;
            }
        }

        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        }
        if (board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }

        return false;
    }
}
