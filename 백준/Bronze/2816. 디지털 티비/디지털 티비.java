
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] channel = new String[N];

        for (int i = 0; i < N; i++) {
            channel[i] = br.readLine();
        }

        int arrowPos = 0;

        int kbs1Pos = findChannel(channel, "KBS1");

        while (arrowPos < kbs1Pos) {
            sb.append("1");
            arrowPos++;
        }
        while (arrowPos > 0) {
            sb.append("4");
            swap(channel, arrowPos, arrowPos - 1);
            arrowPos--;
        }

        int kbs2Pos = findChannel(channel, "KBS2");
        while (arrowPos < kbs2Pos) {
            sb.append("1");
            arrowPos++;
        }
        while (arrowPos > 1) {
            sb.append("4");
            swap(channel, arrowPos, arrowPos - 1);
            arrowPos--;
        }

        System.out.println(sb);
        br.close();
    }

    public static int findChannel(String[] channel, String target) {
        for (int i = 0; i < channel.length; i++) {
            if (channel[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void swap(String[] channel, int i, int j) {
        String temp = channel[i];
        channel[i] = channel[j];
        channel[j] = temp;
    }
}
