import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int lightidx = 0;
        int heavyidx = people.length - 1;

        while (lightidx <= heavyidx) {
            
            if (people[lightidx] + people[heavyidx] <= limit) {
                lightidx++; 
            }
            heavyidx--; 
            answer++; 
        }
        
        return answer;
    }
}
