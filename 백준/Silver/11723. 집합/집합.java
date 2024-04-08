import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int bitmask = 0; // 비트마스킹을 위한 변수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int num = input.length > 1 ? Integer.parseInt(input[1]) : 0;

            switch (command) {
                case "add":
                    bitmask |= (1 << num); // 해당 숫자의 비트를 1로 설정
                    break;
                case "remove":
                    bitmask &= ~(1 << num); // 해당 숫자의 비트를 0으로 설정
                    break;
                case "check":
                    int result = (bitmask & (1 << num)) > 0 ? 1 : 0; // 해당 숫자의 비트가 1인지 확인
                    sb.append(result).append("\n");
                    break;
                case "toggle":
                    bitmask ^= (1 << num); // 해당 숫자의 비트를 반전
                    break;
                case "all":
                    bitmask = (1 << 21) - 1; // 모든 비트를 1로 설정
                    break;
                case "empty":
                    bitmask = 0; // 모든 비트를 0으로 설정
                    break;
            }
        }

        System.out.println(sb);
    }
}
