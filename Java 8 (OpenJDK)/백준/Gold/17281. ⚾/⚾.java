import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] results; 
    static int[] order = new int[10]; 
    static boolean[] visited = new boolean[10];
    static int maxScore = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        results = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                results[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[4] = 1;
        visited[1] = true;

        dfs(1);
        System.out.println(maxScore);
    }

    public static void dfs(int depth) {
        if (depth == 10) {
            playGame();
            return;
        }

        if (depth == 4) { 
            dfs(depth + 1);
            return;
        }

        for (int i = 2; i <= 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }


    public static void playGame() {
        int score = 0;
        int currentHitter = 1; 
        for (int i = 1; i <= N; i++) {
            int outCnt = 0;
            boolean[] base = new boolean[4]; 

            while (outCnt < 3) {
                int hitterNum = order[currentHitter];
                int result = results[i][hitterNum];

                if (result == 0) {
                    outCnt++;
                } 
                else if (result == 4) { 
                    int count = 0;
                    for (int b = 1; b <= 3; b++) {
                        if (base[b]) count++;
                    }
                    score += (count + 1);
                    for (int b = 1; b <= 3; b++) base[b] = false;
                } 
                else { 
                    for (int b = 3; b >= 1; b--) {
                        if (base[b]) {
                            if (b + result >= 4) {
                                score++;
                                base[b] = false;
                            } else {
                                base[b + result] = true;
                                base[b] = false;
                            }
                        }
                    }
                    base[result] = true; 
                }

                currentHitter++;
                if (currentHitter > 9) currentHitter = 1;
            }
        }
        maxScore = Math.max(maxScore, score);
    }
}