
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmb = br.readLine().split(" ");
        int n = Integer.parseInt(nmb[0]);
        int m = Integer.parseInt(nmb[1]);
        int b = Integer.parseInt(nmb[2]);
        int[][] arr = new int[n][m];
        int maxHeight = 0;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(row[j]);
                maxHeight = Math.max(maxHeight, arr[i][j]);
                minHeight = Math.min(minHeight, arr[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int targetHeight = -1;

        for (int height = minHeight; height <= maxHeight; height++) {
            int time = 0;
            int blocks = b;
            int remainBlocks = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int diff = arr[i][j] - height;
                    if (diff > 0) {
                        time += diff * 2;
                        blocks += diff;
                    } else if (diff < 0) {
                        time -= diff;
                        remainBlocks -= diff;
                    }
                }
            }

            if (blocks >= remainBlocks) {
                if (time <= minTime) {
                    minTime = time;
                    targetHeight = height;
                }
            }
        }

        System.out.println(minTime + " " + targetHeight);
    }
}
