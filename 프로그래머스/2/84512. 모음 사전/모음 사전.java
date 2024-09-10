class Solution {
    public int solution(String word) {
            String[] words = {"A", "E", "I", "O", "U"};
            int[] weight = {781, 156, 31, 6, 1};
            int answer = 0;
            int length = word.length();

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < 5; j++) {
                    if (word.charAt(i) == words[j].charAt(0)) {
                        answer += weight[i] * j + 1;
                        break;
                    }
                }
            }

            return answer;
        }
}