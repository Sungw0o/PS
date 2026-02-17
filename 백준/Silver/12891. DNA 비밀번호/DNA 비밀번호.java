import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int S, P;
    private static char[] pwd;
    private static int[] checkArr = new int[4];  
    private static int[] statusArr = new int[4]; 
    private static int result = 0; 

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(result);
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        pwd = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    public static void solve(){
        
        for(int i = 0; i < P; i++) {
            add(pwd[i]); 
        }

        // 초기 검사
        if(check()) {
            result++;
        }


        // 이제 P부터 S-1까지 한 칸씩 오른쪽
        for(int i = P; i < S; i++) {

            int j = i - P; 

            add(pwd[i]);     
            remove(pwd[j]);  


            if(check()){
                result++;
            }
        }
    }

    // 문자를 받아서 statusArr 개수 증가
    private static void add(char c) {
        switch(c){
            case 'A' : statusArr[0]++; break;
            case 'C' : statusArr[1]++; break;
            case 'G' : statusArr[2]++; break;
            case 'T' : statusArr[3]++; break;
        }
    }

    // 문자를 받아서 statusArr 개수 감소 (윈도우에서 빠질 때)
    private static void remove(char c) {
        switch (c){
            case 'A': statusArr[0]--; break;
            case 'C': statusArr[1]--; break;
            case 'G': statusArr[2]--; break;
            case 'T': statusArr[3]--; break;
        }
    }

    // statusArr가 checkArr의 조건을 모두 만족하는지 확인하는 함수
    private static boolean check() {
        for(int i = 0; i < 4; i++){
            if(statusArr[i] < checkArr[i]){
                return false; 
            }
        }
        return true; 
    }
}