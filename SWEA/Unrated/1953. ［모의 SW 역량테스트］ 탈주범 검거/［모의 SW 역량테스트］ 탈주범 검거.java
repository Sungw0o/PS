

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    private static int T, N, M, R, C, L, cnt;
    private static int[][] map;
    private static boolean[][] visited;
    
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static int[][] pipes = {
        {},
        {0, 1, 2, 3},
        {0, 1},
        {2, 3},
        {0, 3},
        {1, 3},
        {1, 2},
        {0, 2}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            visited = new boolean[N][M];
            
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            cnt = bfs();
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        
        System.out.print(sb.toString());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{R, C, 1}); 
        visited[R][C] = true;
        
        int reachableCount = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if (time >= L) continue;

            int currentPipe = map[r][c];

            for (int dir : pipes[currentPipe]) {
                int nr = r + dy[dir];
                int nc = c + dx[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc] || map[nr][nc] == 0) continue;

                if (isConnected(dir, map[nr][nc])) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, time + 1});
                    reachableCount++;
                }
            }
        }
        return reachableCount;
    }

    private static boolean isConnected(int dir, int nextPipe) {
        int oppositeDir = -1;
        
        if (dir == 0) oppositeDir = 1; 
        else if (dir == 1) oppositeDir = 0;
        else if (dir == 2) oppositeDir = 3;
        else if (dir == 3) oppositeDir = 2;

        for (int nextDir : pipes[nextPipe]) {
            if (nextDir == oppositeDir) return true;
        }
        
        return false;
    }
}