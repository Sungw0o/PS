import java.io.*;
import java.util.*;

public class n4153 {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                arr[j] = sc.nextInt();
            }
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
                break;

            Arrays.sort(arr);
            if (arr[2] * arr[2] == arr[0] * arr[0] + arr[1] * arr[1]) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
        sc.close();
    }
}
