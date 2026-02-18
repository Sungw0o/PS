import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, D;
    private static int maxKill = 0;
    private static int[][] map;
    private static int[] archers = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0, 0);

        System.out.println(maxKill);
    }

    public static void comb(int start, int count) {
        if (count == 3) {
            simulate();
            return;
        }

        for (int i = start; i < M; i++) {
            archers[count] = i;
            comb(i + 1, count + 1);
        }
    }

    public static void simulate() {
        int[][] tempMap = copyMap();
        int killed = 0;

        for (int turn = 0; turn < N; turn++) {
            List<int[]> targets = new ArrayList<>();
            
            for (int archerCol : archers) {
                int minDist = Integer.MAX_VALUE;
                int minCol = Integer.MAX_VALUE;
                int targetR = -1, targetC = -1;

                for (int c = 0; c < M; c++) {
                    for (int r = N - 1; r >= 0; r--) {
                        if (tempMap[r][c] == 1) {
                            int dist = Math.abs(N - r) + Math.abs(archerCol - c);

                            if (dist <= D) {
                                if (dist < minDist) {
                                    minDist = dist;
                                    minCol = c;
                                    targetR = r;
                                    targetC = c;
                                } else if (dist == minDist) {
                                    if (c < minCol) {
                                        minCol = c;
                                        targetR = r;
                                        targetC = c;
                                    }
                                }
                            }
                        }
                    }
                }

                if (targetR != -1) {
                    targets.add(new int[]{targetR, targetC});
                }
            }

            for (int[] t : targets) {
                if (tempMap[t[0]][t[1]] == 1) {
                    tempMap[t[0]][t[1]] = 0;
                    killed++;
                }
            }

            move(tempMap);
        }

        maxKill = Math.max(maxKill, killed);
    }

    public static void move(int[][] tempMap) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = tempMap[i - 1][j];
            }
        }
        for (int j = 0; j < M; j++) {
            tempMap[0][j] = 0;
        }
    }

    public static int[][] copyMap() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        return temp;
    }
}