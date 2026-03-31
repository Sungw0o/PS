import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int N, M, rR, rC, rDir, areaCnt;
    private static int[][] arr;

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        rR = Integer.parseInt(st.nextToken());
        rC = Integer.parseInt(st.nextToken());
        rDir = Integer.parseInt(st.nextToken());
        
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(rR, rC, rDir);
        System.out.println(areaCnt);
        br.close();
    }

    private static void clean(int r, int c, int dir) {
        if (arr[r][c] == 0) {
            arr[r][c] = 2; 
            areaCnt++;
        }

        boolean foundEmpty = false;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (arr[nr][nc] == 0) {
                    foundEmpty = true;
                    break;
                }
            }
        }

        if (foundEmpty) {
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nr][nc] == 0) {
                    clean(nr, nc, dir);
                    return;
                }
            }
        } else {

            int backDir = (dir + 2) % 4;
            int br = r + dr[backDir];
            int bc = c + dc[backDir];

            if (br >= 0 && br < N && bc >= 0 && bc < M && arr[br][bc] != 1) {
                clean(br, bc, dir);
            } else {
                return;
            }
        }
    }
}