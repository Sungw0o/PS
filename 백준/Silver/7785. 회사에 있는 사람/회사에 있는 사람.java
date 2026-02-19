
import java.io.*;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet<>((s1, s2) -> s2.compareTo(s1)); // 역순으로 정렬

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String entry = br.readLine();

            // "enter" 명령인 경우 TreeSet에 추가, "leave" 명령인 경우 TreeSet에서 제거
            if (entry.contains("enter")) {
                set.add(entry.split(" ")[0]);
            } else if (entry.contains("leave")) {
                set.remove(entry.split(" ")[0]);
            }
        }

        // TreeSet의 요소를 출력 (역순으로 정렬되어 있음)
        for (String name : set) {
            System.out.println(name);
        }

        br.close();
    }
}