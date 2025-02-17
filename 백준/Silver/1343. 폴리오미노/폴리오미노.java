import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final String A = "AAAA";
    static final String B = "BB";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int xCnt = 0;
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (c == 'X') {
                xCnt++;
            } else {
                if (xCnt > 0) {
                    if (xCnt % 2 != 0) {
                        System.out.println("-1");
                        return;
                    }
                    sb.append(replaceX(xCnt));
                    xCnt = 0;
                }
                sb.append('.');
            }
        }
        
        if (xCnt > 0) {
            if (xCnt % 2 != 0) {
                System.out.println("-1");
                return;
            }
            sb.append(replaceX(xCnt));
        }
        
        System.out.println(sb);
        br.close();
    }

    private static String replaceX(int count) {
        StringBuilder result = new StringBuilder();
        while (count >= 4) {
            result.append(A);
            count -= 4;
        }
        while (count >= 2) {
            result.append(B);
            count -= 2;
        }
        return result.toString();
    }
}
