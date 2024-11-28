import java.io.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] voca = new String[N];

        for(int i =0; i<N;i++){
            voca[i] = br.readLine();
        }

        prefixCheck(voca);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    private static void prefixCheck(String[] voca){
        int maxLen = 0;
        int firstIdx = 0, secondIdx = 0;

        for (int i = 0; i < voca.length; i++) {
            for (int j = i + 1; j < voca.length; j++) {
                int prefixLen = prefixLength(voca[i], voca[j]);

                if (prefixLen > maxLen) {
                    maxLen = prefixLen;
                    firstIdx = i;
                    secondIdx = j;
                }
            }
        }
        sb.append(voca[firstIdx]).append("\n");
        sb.append(voca[secondIdx]).append("\n");
    }

    private static int prefixLength(String voca1, String voca2){
        int len = Math.min(voca1.length(),voca2.length());
        int prefixLen = 0;

        for (int i = 0; i < len; i++) {
            if (voca1.charAt(i) == voca2.charAt(i)) {
                prefixLen++;
            } else {
                break;
            }
        }
        return prefixLen;
    }
}
