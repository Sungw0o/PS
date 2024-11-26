import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static StringBuilder sb;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> dic = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String word = br.readLine();

            if (freqChk(dic, word)) {
                int freq = dic.get(word);
                dic.replace(word, freq + 1);
                continue;
            }

            if (lenChk(word)) {
                dic.put(word, 0);
            }
        }

        List<Map.Entry<String, Integer>> sortedList = sortDic(dic);
        addDic(sortedList);

        System.out.println(sb);

        br.close();
    }

    public static boolean lenChk(String str) {
        return str.length() >= M;
    }

    public static boolean freqChk(HashMap<String, Integer> dic, String word) {
        return dic.containsKey(word);
    }

    public static List<Map.Entry<String, Integer>> sortDic(HashMap<String, Integer> dic) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(dic.entrySet());
        sortedList.sort((e1, e2) -> {

            int freqCompare = Integer.compare(e2.getValue(), e1.getValue());
            if (freqCompare != 0) return freqCompare;

            int lenCompare = Integer.compare(e2.getKey().length(), e1.getKey().length());
            if (lenCompare != 0) return lenCompare;

            return e1.getKey().compareTo(e2.getKey());
        });
        return sortedList;
    }

    private static void addDic(List<Map.Entry<String, Integer>> sortedList) {
        for (Map.Entry<String, Integer> entry : sortedList) {
            sb.append(entry.getKey()).append("\n");
        }
    }
}
