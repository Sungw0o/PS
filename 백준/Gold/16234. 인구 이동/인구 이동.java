import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int dayCnt = 0;
    static List<int[]> union;
    static int unionPopSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            visited = new boolean[N][N];
            boolean popMovement = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        union = new ArrayList<>();
                        unionPopSum = 0;
                        checkPopDiff(i,j);
                    }

                    

                    if(union.size() > 1){
                        popMovement = true;
                        popRedistribution();
                    }
                }
            }
            if(!popMovement){
                break;
            }
            dayCnt++;
        }

        System.out.println(dayCnt);
        br.close();

    }

    public static void checkPopDiff(int x, int y){

        visited[x][y] = true;
        union.add(new int[]{x,y});
        unionPopSum += map[x][y];

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]){
                int popDiff = Math.abs(map[x][y] - map[nx][ny]);
                if(L<=popDiff && R>=popDiff){
                    checkPopDiff(nx,ny);
                }
            }
        }
    }

    public static void popRedistribution(){
        int newPop = unionPopSum / union.size();
        for(int[] pop : union){
            map[pop[0]][pop[1]] = newPop;
        }
    }
}
