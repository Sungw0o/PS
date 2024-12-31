import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] switchs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());
        switchs = new int[S + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= S; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int inputNum = Integer.parseInt(st.nextToken());

            if (student == 1)
                boy(inputNum, S);
            else
                girl(inputNum, S);
        }

        for (int i = 1; i <= S; i++) {
            System.out.print(switchs[i] + " "); 
            if (i % 20 == 0) System.out.println();
        }

        br.close();
    }

    public static void boy(int num, int size) {
        for (int n = num; n <= size; n += num) {
            switchs[n] = 1 - switchs[n];
        }
    }

    public static void girl(int num, int size) {
        int left = num;
        int right = num;

        while (left > 0 && right <= size && switchs[left] == switchs[right]) {
            left--;
            right++;
        }

        for (int n = left + 1; n < right; n++) {
            switchs[n] = 1 - switchs[n];
        }
    }
}
