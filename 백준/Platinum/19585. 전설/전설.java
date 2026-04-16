import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 트라이 노드 최대 개수 (C * L = 4,000 * 1,000)
    static final int MAX = 4000005;
    static int[][] trie = new int[MAX][26];
    static boolean[] isEnd = new boolean[MAX];
    static int nodeCnt = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // 1. 색상은 트라이에 삽입
        for (int i = 0; i < C; i++) {
            String s = br.readLine();
            int curr = 0;
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (trie[curr][idx] == 0) trie[curr][idx] = nodeCnt++;
                curr = trie[curr][idx];
            }
            isEnd[curr] = true;
        }
        
        // 2. 닉네임은 HashSet에 삽입 (메모리 및 인덱스 에러 방지)
        HashSet<String> nicknames = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nicknames.add(br.readLine());
        }
        
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (Q-- > 0) {
            String team = br.readLine();
            int curr = 0;
            boolean possible = false;
            
            // 팀 이름을 앞에서부터 한 글자씩 트라이로 탐색
            for (int i = 0; i < team.length(); i++) {
                int idx = team.charAt(i) - 'a';
                curr = trie[curr][idx];
                
                if (curr == 0) break; // 트라이 경로 끊기면 중단
                
                // 현재까지가 유효한 색상(Prefix)이라면
                if (isEnd[curr]) {
                    // 남은 부분(Suffix)이 닉네임 목록에 있는지 확인
                    String suffix = team.substring(i + 1);
                    if (nicknames.contains(suffix)) {
                        possible = true;
                        break;
                    }
                }
            }
            sb.append(possible ? "Yes\n" : "No\n");
        }
        System.out.print(sb);
    }
}