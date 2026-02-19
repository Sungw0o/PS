

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> nameToIndex = new HashMap<>();
        HashMap<Integer, String> indexToName = new HashMap();

        String s = br.readLine();
        String[] nm = s.split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i++) {
            String val = br.readLine();
            nameToIndex.put(val, i);
            indexToName.put(i, val);
        }

        for (int i = 0; i < m; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                // 숫자로 시작하는 경우, 번호로 이름 찾기
                int index = Integer.parseInt(query);
                System.out.println(indexToName.get(index));
            } else {
                // 문자로 시작하는 경우, 이름으로 번호 찾기
                System.out.println(nameToIndex.get(query));
            }
        }

        br.close();
    }
}
