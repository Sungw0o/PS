import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] cookie;
    static int rtarm, ltarm, ltleg, rtleg = 0;
    static int heartx, hearty;
    static int waist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cookie = new char[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                cookie[i][j] = s.charAt(j - 1);
            }
        }

        int head = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cookie[i][j] == '*' && head == 0) {
                    heartx = i + 1;
                    hearty = j;
                    head = i;
                }
                if (i == head + 1 && cookie[i][j] == '*' && j < hearty) {
                    ltarm++;
                }
                if (i == head + 1 && cookie[i][j] == '*' && j > hearty) {
                    rtarm++;
                }
                if (j == hearty && i > heartx && cookie[i][j] == '*') {
                    waist++;
                }
            }
        }

        for (int i = heartx + waist; i <= N; i++) {
            if (cookie[i][hearty - 1] == '*') ltleg++;
            if (cookie[i][hearty + 1] == '*') rtleg++;
        }

        System.out.println(heartx + " " + hearty);
        System.out.println(ltarm + " " + rtarm + " " + waist + " " + ltleg + " " + rtleg);
        br.close();
    }
}
