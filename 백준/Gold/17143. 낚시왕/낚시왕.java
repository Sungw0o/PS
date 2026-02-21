import java.io.InputStream;

public class Main {
    private static int[] sR, sC, sSpeed, sDir, sSize;
    private static int[] map, nextMap;

    public static void main(String[] args) throws Exception {
        int R = read();
        int C = read();
        int M = read();

        if (M == 0) {
            System.out.print(0);
            return;
        }

        int R_cycle = (R - 1) << 1;
        int C_cycle = (C - 1) << 1;
        int totalCells = R * C;

        map = new int[totalCells];
        nextMap = new int[totalCells];

        sR = new int[M + 1];
        sC = new int[M + 1];
        sSpeed = new int[M + 1];
        sDir = new int[M + 1];
        sSize = new int[M + 1];

        for (int i = 1; i <= M; i++) {
            sR[i] = read() - 1;
            sC[i] = read() - 1;
            sSpeed[i] = read();
            sDir[i] = read();
            sSize[i] = read();

            if (sDir[i] <= 2) {
                sSpeed[i] %= R_cycle;
            } else {
                sSpeed[i] %= C_cycle;
            }

            map[sR[i] * C + sC[i]] = i;
        }

        int sum = 0;

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                int pos = j * C + i;
                if (map[pos] != 0) {
                    int id = map[pos];
                    sum += sSize[id];
                    sSize[id] = 0;
                    map[pos] = 0;
                    break;
                }
            }

            for (int id = 1; id <= M; id++) {
                if (sSize[id] == 0) continue;

                int r = sR[id];
                int c = sC[id];
                int s = sSpeed[id];
                int d = sDir[id];

                if (d <= 2) {
                    int p = (d == 1) ? (R_cycle - r + s) : (r + s);
                    p %= R_cycle;
                    if (p >= R) {
                        r = R_cycle - p;
                        d = 1;
                    } else {
                        r = p;
                        d = 2;
                    }
                    sR[id] = r;
                    sDir[id] = d;
                } else {
                    int p = (d == 4) ? (C_cycle - c + s) : (c + s);
                    p %= C_cycle;
                    if (p >= C) {
                        c = C_cycle - p;
                        d = 4;
                    } else {
                        c = p;
                        d = 3;
                    }
                    sC[id] = c;
                    sDir[id] = d;
                }

                int pos = r * C + c;
                if (nextMap[pos] == 0) {
                    nextMap[pos] = id;
                } else {
                    int existId = nextMap[pos];
                    if (sSize[id] > sSize[existId]) {
                        sSize[existId] = 0;
                        nextMap[pos] = id;
                    } else {
                        sSize[id] = 0;
                    }
                }
            }

            int[] temp = map;
            map = nextMap;
            nextMap = temp;

            for (int j = 0; j < totalCells; j++) {
                nextMap[j] = 0;
            }
        }

        System.out.print(sum);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}