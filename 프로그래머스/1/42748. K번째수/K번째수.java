import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            int[] temp = new int[j - i + 1];
            int tempIdx = 0;
            
            for (int num = i - 1; num < j; num++) {
                temp[tempIdx++] = array[num];
            }
            
            Arrays.sort(temp);
            answer[idx] = temp[k - 1];
        }
        
        return answer;
    }
}