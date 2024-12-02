import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static final String YUT_NO_RI = "Y";
    private static final String FIND_THE_SAME_PICTURE = "F";
    private static final String ONE_CARD = "O";
    private static HashSet<String> nameList = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String gameType = st.nextToken();

        for (int i = 0; i < N; i++) {
            nameList.add(br.readLine());
        }

        int result = gameCount(gameType, nameList);

        System.out.println(result);
        br.close();
    }

    public static int gameCount(String gameType, HashSet<String> nameList) {
        int playersPerGame;

        switch (gameType) {
            case YUT_NO_RI:
                playersPerGame = 1;
                break;
            case FIND_THE_SAME_PICTURE:
                playersPerGame = 2;
                break;
            case ONE_CARD:
                playersPerGame = 3;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 게임입니다.");
        }

        return nameList.size() / playersPerGame;
    }
}
