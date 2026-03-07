import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static int N,M;

    private static final int MAX_NODE = 5000005;
    private static int[][] trie;
    private static boolean[] isEnd;
    private static int nodeCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();

        for(int i = 0; i < N; i++){
            insert(br.readLine());
        }

        int cnt = 0;

        for(int i = 0; i < M; i++){
            if(search(br.readLine())){
                cnt++;
            }
        }

        sb.append(cnt);
        System.out.println(cnt);

        br.close();

    }

    public static void init(){
        trie = new int[MAX_NODE][26];
        isEnd = new boolean[MAX_NODE];
        nodeCnt = 0;
    }

    public static void insert(String str){
        int curr = 0;
        for(int i = 0; i < str.length();i++){
            int c = str.charAt(i) -'a';
            if(trie[curr][c] == 0){
                trie[curr][c] = ++nodeCnt;
            }

            curr = trie[curr][c];
        }
        isEnd[curr] = true;
    }

    public static boolean search(String str){
        int curr = 0;
        for(int i  = 0; i < str.length();i++){
            int c = str.charAt(i) -'a';
            if(trie[curr][c] == 0){
                return false;
            }
            curr = trie[curr][c];
        }

        return isEnd[curr];
    }
}
