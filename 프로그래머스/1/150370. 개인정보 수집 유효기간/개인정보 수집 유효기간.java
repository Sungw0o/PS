import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> expired = new ArrayList();
        HashMap<String, Integer> termsMap = new HashMap();

        int todayDays = convertDateToDays(today);

        for (String str : terms){
            String[] term  = str.split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++){
            String[] privacy = privacies[i].split(" ");

            if(convertDateToDays(privacy[0]) + (termsMap.get(privacy[1])* 28) <= todayDays){
                expired.add(i + 1);
            }
        }
        
        int[] answer = new int[expired.size()];
        for (int i = 0; i < expired.size(); i++) {
            answer[i] = expired.get(i);
        }

        return answer;
    }

    private int convertDateToDays(String date) {
        String[] parts = date.split("\\.");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }
}
