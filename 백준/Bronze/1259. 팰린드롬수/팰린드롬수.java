
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            StringBuilder test = new StringBuilder(str);
            if(str.equals("0"))
                break;
            String rev = test.reverse().toString();
            if(rev.equals(str))
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb);
    }
}
