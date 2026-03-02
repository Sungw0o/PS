import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[][] board = new int[5][5];
    private static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int callCnt = 0;
        boolean finished = false;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callCnt++;

                for (int r = 0; r < 5; r++) {
                    for (int c = 0; c < 5; c++) {
                        if (board[r][c] == num) {
                            visited[r][c] = true;
                        }
                    }
                }

                if (checkBingo() >= 3) {
                    sb.append(callCnt);
                    finished = true;
                    break;
                }
            }
            if (finished) break;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int checkBingo() {
        int bingo = 0;

        for (int i = 0; i < 5; i++) {
            int rowCount = 0;
            int colCount = 0;
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) rowCount++;
                if (visited[j][i]) colCount++;
            }
            if (rowCount == 5) bingo++;
            if (colCount == 5) bingo++;
        }

        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i][i]) diag1++;
            if (visited[i][4 - i]) diag2++;
        }
        if (diag1 == 5) bingo++;
        if (diag2 == 5) bingo++;

        return bingo;
    }
}