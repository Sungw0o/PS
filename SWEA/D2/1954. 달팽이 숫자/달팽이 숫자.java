import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수 입력
        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            // 방향 설정: 우, 하, 좌, 상 순서
            int[] dr = {0, 1, 0, -1}; // 행(row) 변화량
            int[] dc = {1, 0, -1, 0}; // 열(col) 변화량
            
            int r = 0; // 현재 행 위치
            int c = 0; // 현재 열 위치
            int d = 0; // 방향 인덱스 (0:우, 1:하, 2:좌, 3:상)

            for(int i = 1; i <= N * N; i++) {
                map[r][c] = i; // 현재 위치에 숫자 입력

                // 다음 위치 계산
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 다음 위치가 격자를 벗어나거나, 이미 숫자가 채워진 곳이라면 방향 전환
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                    d = (d + 1) % 4; // 방향 전환 (0->1->2->3->0...)
                    nr = r + dr[d];
                    nc = c + dc[d];
                }

                // 위치 업데이트
                r = nr;
                c = nc;
            }

            // 결과 출력
            System.out.println("#" + t);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}