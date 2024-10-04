import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int row, col;

    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;

        int[][] effort = new int[row][col];
        Arrays.stream(effort).forEach(r -> Arrays.fill(r, Integer.MAX_VALUE));

        effort[0][0] = 0;

    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] location = pq.poll();
            int difference = location[0];
            int x = location[1];
            int y = location[2];

            if (x == row - 1 && y == col - 1) {
                return difference;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < row && ny < col) {
                    int currentDiff = Math.abs(heights[nx][ny] - heights[x][y]);
                    int maxDiff = Math.max(currentDiff, difference);

                    if (maxDiff < effort[nx][ny]) {
                        effort[nx][ny] = maxDiff;
                        pq.offer(new int[]{maxDiff, nx, ny});
                    }
                }
            }
        }

        return 0;
    }
}
