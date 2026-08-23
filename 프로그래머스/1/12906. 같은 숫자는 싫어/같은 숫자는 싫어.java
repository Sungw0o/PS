import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : arr) {
            // 스택이 비어있거나, 이전 숫자와 다를 때만 push
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        // 스택 크기만큼 배열 생성
        int[] answer = new int[stack.size()];
        
        // Stack은 LIFO이므로 뒤에서부터 채우기 (또는 get(i) / 향상된 for문 활용)
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        
        return answer;
    }
}