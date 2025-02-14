import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        System.out.println(dfs(B, A) ? 1 : 0);
        br.close();
    }

    public static boolean dfs(String cur, String target) {
        if (cur.equals(target)) return true;
        if (cur.length() <= target.length()) return false;

        return (cur.charAt(cur.length() - 1) == 'A' && dfs(cur.substring(0, cur.length() - 1), target)) ||
                (cur.charAt(0) == 'B' && dfs(new StringBuilder(cur).reverse().substring(0, cur.length() - 1), target));
    }
}
