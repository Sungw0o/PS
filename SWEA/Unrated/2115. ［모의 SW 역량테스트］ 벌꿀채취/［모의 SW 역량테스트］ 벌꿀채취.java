import java.io.*;
import java.util.*;

public class Solution {
    private static int N, M, C;
    private static int[][] map;
    private static int[][] profitMap;
    private static int finalMaxProfit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            init(br, st);
            solve();
            System.out.println("#" + test_case + " " + finalMaxProfit);
        }
    }

    private static void init(BufferedReader br, StringTokenizer st) throws IOException {
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        profitMap = new int[N][N];
        finalMaxProfit = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void solve() {
        buildProfitMap();
        findBestCombination();
    }

    private static void buildProfitMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                int[] honeySegment = new int[M];
                for (int k = 0; k < M; k++) {
                    honeySegment[k] = map[i][j + k];
                }
                profitMap[i][j] = calculateMaxHoney(honeySegment);
            }
        }
    }

    private static int calculateMaxHoney(int[] segment) {
        return dfs(0, 0, 0, segment);
    }

    private static int dfs(int depth, int sumHoney, int sumProfit, int[] segment) {
        if (sumHoney > C) return 0;

        if (depth == M) {
            return sumProfit;
        }

        int pick = 0;
        if (sumHoney + segment[depth] <= C) {
            pick = dfs(depth + 1, 
                       sumHoney + segment[depth], 
                       sumProfit + (segment[depth] * segment[depth]), 
                       segment);
        }

        int skip = dfs(depth + 1, sumHoney, sumProfit, segment);

        return Math.max(pick, skip);
    }

    private static void findBestCombination() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= N - M; j++) {
                for (int r = i; r < N; r++) {
                    int startCol = (r == i) ? (j + M) : 0; 
                    
                    for (int c = startCol; c <= N - M; c++) {
                        int currentTotal = profitMap[i][j] + profitMap[r][c];
                        finalMaxProfit = Math.max(finalMaxProfit, currentTotal);
                    }
                }
            }
        }
    }
}