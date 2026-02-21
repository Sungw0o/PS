import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, M, sum;

    private static int[][] arr;
    private static int[][] tempArr;

    private static int[] sR;
    private static int[] sC;
    private static int[] sSpeed;
    private static int[] sDir;
    private static int[] sSize;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = 0;

        arr = new int[R + 1][C + 1];
        tempArr = new int[R + 1][C + 1];

        sR = new int[M + 1];
        sC = new int[M + 1];
        sSpeed = new int[M + 1];
        sDir = new int[M + 1];
        sSize = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            sR[i] = Integer.parseInt(st.nextToken());
            sC[i] = Integer.parseInt(st.nextToken());
            sSpeed[i] = Integer.parseInt(st.nextToken());
            sDir[i] = Integer.parseInt(st.nextToken());
            sSize[i] = Integer.parseInt(st.nextToken());

            arr[sR[i]][sC[i]] = i;
        }

        for (int i = 1; i <= C; i++) {

            for (int j = 1; j <= R; j++) {
                if (arr[j][i] != 0) {
                    int id = arr[j][i];
                    sum += sSize[id];
                    sSize[id] = 0;
                    arr[j][i] = 0;
                    break;
                }
            }

            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    tempArr[j][k] = 0;
                }
            }

            for (int id = 1; id <= M; id++) {
                if (sSize[id] == 0) continue;

                int r = sR[id];
                int c = sC[id];
                int s = sSpeed[id];
                int d = sDir[id];

                if (d == 1 || d == 2) {
                    int move = s % ((R - 1) * 2);
                    for (int k = 0; k < move; k++) {
                        if (r == 1) d = 2;
                        else if (r == R) d = 1;
                        r += (d == 1) ? -1 : 1;
                    }
                }
                else {
                    int move = s % ((C - 1) * 2);
                    for (int k = 0; k < move; k++) {
                        if (c == 1) d = 3;
                        else if (c == C) d = 4;
                        c += (d == 3) ? 1 : -1;
                    }
                }

                sR[id] = r;
                sC[id] = c;
                sDir[id] = d;

                if (tempArr[r][c] == 0) {
                    tempArr[r][c] = id;
                } else {
                    int existId = tempArr[r][c];
                    if (sSize[id] > sSize[existId]) {
                        sSize[existId] = 0;
                        tempArr[r][c] = id;
                    } else {
                        sSize[id] = 0;
                    }
                }
            }

            for (int j = 1; j <= R; j++) {
                for (int k = 1; k <= C; k++) {
                    arr[j][k] = tempArr[j][k];
                }
            }
        }

        sb.append(sum).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}