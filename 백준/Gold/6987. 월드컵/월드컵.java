import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] win = new int[4][6];
    static int[][] draw = new int[4][6];
    static int[][] lose = new int[4][6];
    static boolean[] possible = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 0; t < 4; t++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                win[t][i] = Integer.parseInt(st.nextToken());
                draw[t][i] = Integer.parseInt(st.nextToken());
                lose[t][i] = Integer.parseInt(st.nextToken());
            }
            if (!isValid(t)) {
                possible[t] = false;
            } else {
                backTracking(t, 0, 1);
            }
        }

        for (int t = 0; t < 4; t++) {
            System.out.print((possible[t] ? 1 : 0) + " ");
        }
    }

    static boolean isValid(int t) {
        int totalGames = 0;
        for (int i = 0; i < 6; i++) {
            totalGames += win[t][i] + draw[t][i] + lose[t][i];
        }
        return totalGames == 30;
    }

    static void backTracking(int t, int team1, int team2) {
        if (possible[t]) return;
        if (team1 == 5) {
            possible[t] = true;
            return;
        }

        if (team2 == 6) {
            backTracking(t, team1 + 1, team1 + 2);
            return;
        }
        
        if (win[t][team1] > 0 && lose[t][team2] > 0) {
            win[t][team1]--;
            lose[t][team2]--;
            backTracking(t, team1, team2 + 1);
            win[t][team1]++;
            lose[t][team2]++;
        }
        
        if (draw[t][team1] > 0 && draw[t][team2] > 0) {
            draw[t][team1]--;
            draw[t][team2]--;
            backTracking(t, team1, team2 + 1);
            draw[t][team1]++;
            draw[t][team2]++;
        }
        
        if (lose[t][team1] > 0 && win[t][team2] > 0) {
            lose[t][team1]--;
            win[t][team2]--;
            backTracking(t, team1, team2 + 1);
            lose[t][team1]++;
            win[t][team2]++;
        }
    }
}
