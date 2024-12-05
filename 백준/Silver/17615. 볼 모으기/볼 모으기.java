import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ballArray = br.readLine().toCharArray();

        int rCnt = countBalls(ballArray, 'R');
        int bCnt = countBalls(ballArray, 'B');

        if (isSingleColor(rCnt, bCnt)) {
            System.out.println(0);
            return;
        }

        int minMoves = calcMoves(ballArray, rCnt, bCnt);
        System.out.println(minMoves);
    }

    private static int countBalls(char[] ballArray, char color) {
        int count = 0;
        for (char ball : ballArray) {
            if (ball == color) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSingleColor(int rCnt, int bCnt) {
        return rCnt == 0 || bCnt == 0;
    }

    private static int calcMoves(char[] ballArray, int rCnt, int bCnt) {
        int leftR = countConsecutive(ballArray, 'R', true);
        int leftB = countConsecutive(ballArray, 'B', true);
        int rightR = countConsecutive(ballArray, 'R', false);
        int rightB = countConsecutive(ballArray, 'B', false);

        int moveLeftR = rCnt - leftR;
        int moveLeftB = bCnt - leftB;
        int moveRightR = rCnt - rightR;
        int moveRightB = bCnt - rightB;

        return Math.min(Math.min(moveLeftR, moveLeftB), Math.min(moveRightR, moveRightB));
    }

    private static int countConsecutive(char[] ballArray, char color, boolean fromLeft) {
        int count = 0;
        if (fromLeft) {
            for (char ball : ballArray) {
                if (ball == color) {
                    count++;
                } else {
                    break;
                }
            }
        } else {
            for (int i = ballArray.length - 1; i >= 0; i--) {
                if (ballArray[i] == color) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

}
