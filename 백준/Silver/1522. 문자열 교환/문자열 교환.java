import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(swap(str));

        br.close();
        
    }

    public static int swap(String s){

        int length = s.length();
        int aCnt = 0;

        for(char c : s.toCharArray()){
            if(c == 'a'){
                aCnt++;
            }
        }

        if(aCnt == 0 || aCnt == length){
            return 0;
        }

        String extendStr = s + s;
        char[] extendArr = extendStr.toCharArray();

        int minbCnt = Integer.MAX_VALUE;
        int bCnt = 0;

        for(int i =0; i<aCnt; i++){
            if(extendArr[i] == 'b'){
                bCnt++;}
        }

        minbCnt = Math.min(minbCnt, bCnt);

        for(int i = 1; i< length; i++){
            if(extendArr[i-1] == 'b'){
                bCnt--;
            }
            if(extendArr[i+aCnt -1] == 'b'){
                bCnt++;
            }
            minbCnt = Math.min(minbCnt, bCnt);
        }

        return minbCnt;

    }
}
