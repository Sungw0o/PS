import java.util.Scanner;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[] alphabetVisited; 
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        R = s.nextInt();
        C = s.nextInt();
        s.nextLine();

        map = new char[R][C];
        alphabetVisited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String line = s.nextLine();
            map[i] = line.toCharArray();
        }

        dfs(0, 0, 1);
        System.out.println(cnt);
    }

    public static void dfs(int x, int y, int depth) {
        alphabetVisited[map[x][y] - 'A'] = true;
        cnt = Math.max(cnt, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !alphabetVisited[map[nx][ny] - 'A']) {
                dfs(nx, ny, depth + 1);
            }
        }

        alphabetVisited[map[x][y] - 'A'] = false;
    }
}
