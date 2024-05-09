import java.io.*;

public class Main {
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] square = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                square[i][j] = Integer.parseInt(row[j]);
            }
        }
        divide(square, 0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int[][] arr, int x, int y, int size) {
        if (check(arr, x, y, size)) {
            if (arr[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        divide(arr, x, y, newSize);
        divide(arr, x, y + newSize, newSize);
        divide(arr, x + newSize, y, newSize);
        divide(arr, x + newSize, y + newSize, newSize);
    }

    static boolean check(int[][] arr, int x, int y, int size) {
        int color = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}
