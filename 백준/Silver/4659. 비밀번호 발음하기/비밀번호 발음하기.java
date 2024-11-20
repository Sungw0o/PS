import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static String[] vowel = {"a","e","i","o","u"};
    private static final String ACCEPTABLE = "is acceptable.";
    private static final String NOT_ACCEPTABLE = "is not acceptable.";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        while(!(input = br.readLine()).equals("end")){
            if (check(input)) {
                sb.append("<").append(input).append("> ").append(ACCEPTABLE).append("\n");
            } else {
                sb.append("<").append(input).append("> ").append(NOT_ACCEPTABLE).append("\n");
            }
        }

        System.out.println(sb);
        
        br.close();
        
    }

    static boolean check(String s) {
        boolean hasVowel = false;
        for (String str : vowel){
            if(s.contains(str)){
                hasVowel = true;
                break;
            }
        }
        if(!hasVowel) return false;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1) && !(s.charAt(i) == 'e' || s.charAt(i) == 'o')){
                return false;
            }
        }

        int vowelCount = 0, consonantCount = 0;
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) { 
                vowelCount++;
                consonantCount = 0;
            } else { 
                consonantCount++;
                vowelCount = 0;
            }

            if (vowelCount >= 3 || consonantCount >= 3) {
                return false; 
            }
        }

        return true;
    }
}
