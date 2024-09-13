import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        placeQueen(0);
        System.out.println(cnt);
        br.close();
    }

    public static void placeQueen(int x) {
        if (x == N) {
            cnt++;
            return;
        }

        for (int y = 0; y < N; y++) {
            if (isSafe(y, x)) {
                map[y][x] = 1;
                placeQueen(x + 1);
                map[y][x] = 0;
            }
        }
    }
    
    public static boolean isSafe(int y, int x) {
        for (int i = 0; i < x; i++) {
            if (map[y][i] == 1) return false;
            if (y - (x - i) >= 0 && map[y - (x - i)][i] == 1) return false;
            if (y + (x - i) < N && map[y + (x - i)][i] == 1) return false;
        }

        return true;
    }
}
