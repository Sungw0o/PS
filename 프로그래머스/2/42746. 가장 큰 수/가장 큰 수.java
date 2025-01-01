import java.util.ArrayList;
import java.util.Collections;

class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            ArrayList<String> result = new ArrayList<>();
            
            for (int num : numbers) {
                result.add(String.valueOf(num));
            }
            
            Collections.sort(result, (a, b) -> (b + a).compareTo(a + b));
            
            if (result.get(0).equals("0")) {
                return "0";
            }
            
            for (String str : result) {
                sb.append(str);
            }

            return sb.toString();
        }
    }