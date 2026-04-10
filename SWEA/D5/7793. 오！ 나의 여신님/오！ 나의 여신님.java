

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static int T, N, M, ans;

    private static char[][] map;
    private static boolean[][] visited;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};

    private static Queue<Node> devilQueue = new LinkedList<>();
    private static Queue<Node> personQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            ans = 0;

            map = new char[N][M];
            visited = new boolean[N][M];
            
            devilQueue.clear();
            personQueue.clear();

            for(int j = 0; j < N; j++){
                map[j] = br.readLine().toCharArray();

                for (int k = 0; k < M; k++) {
                    if (map[j][k] == '*') {
                        devilQueue.add(new Node(j, k));
                    } else if (map[j][k] == 'S') {
                        personQueue.add(new Node(j, k));
                        visited[j][k] = true;
                    }
                }
            }

            if (move()) {
                sb.append("#").append(i).append(" ").append(ans).append("\n");
            } else {
                sb.append("#").append(i).append(" GAME OVER\n");
            }
        }

        System.out.print(sb);
        br.close();
    }

    public static boolean move(){

        while(!personQueue.isEmpty()){

            int dSize = devilQueue.size();
            for(int i = 0; i < dSize; i++){
                Node devil = devilQueue.poll();

                for(int k = 0; k < 4; k++){
                    int nr = devil.r + dr[k];
                    int nc = devil.c + dc[k];

                    if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if(map[nr][nc] == '.' || map[nr][nc] == 'S') {
                            map[nr][nc] = '*';
                            devilQueue.add(new Node(nr, nc));
                        }
                    }
                }
            }

            int pSize = personQueue.size();

            for(int i = 0; i < pSize; i++){
                Node person = personQueue.poll();

                if(map[person.r][person.c] == 'D'){
                    return true;
                }

                for(int d = 0; d < 4; d++) {
                    int nr = person.r + dr[d];
                    int nc = person.c + dc[d];

                    if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        if((map[nr][nc] == '.' || map[nr][nc] == 'D') && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            personQueue.add(new Node(nr, nc));
                        }
                    }
                }
            }

            ans++;
        }
        
        return false;
    }

    public static class Node{
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}