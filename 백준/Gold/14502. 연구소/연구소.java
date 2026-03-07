import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N,M;
    private static int maxsafeArea = 0;
    private static int[][] map;

    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    private static ArrayList<int[]> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virusList.add(new int[]{i,j});
                }
            }
        }

        buildWall(0);
        System.out.println(maxsafeArea);
        br.close();
    }


    public static void buildWall(int cnt){

        if(cnt == 3) {
            spreadVirus();
            return;
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }



    }


    public static void spreadVirus(){
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int[] v: virusList){
            q.add(new int[]{v[0],v[1]});
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (tempMap[nx][ny] == 0) {
                        tempMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int safeArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    safeArea++;
                }
            }
        }

        if (safeArea > maxsafeArea) {
            maxsafeArea = safeArea;
        }
    }
}
