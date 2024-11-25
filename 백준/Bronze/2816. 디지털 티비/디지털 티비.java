
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

        int pointer = 0;

        int kbs1Pos = findChannel(channel, "KBS1");
        while (pointer < kbs1Pos) {
            sb.append("1");
            pointer++;
        }
        while (pointer > 0) {
            sb.append("4");
            swap(channel, pointer, pointer - 1);
            pointer--;
        }

        int kbs2Pos = findChannel(channel, "KBS2");
        while (pointer < kbs2Pos) {
            sb.append("1");
            pointer++;
        }
        while (pointer > 1) {
            sb.append("4");
            swap(channel, pointer, pointer - 1);
            pointer--;
        }

        System.out.println(sb.toString());
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
