import java.util.ArrayList;
import java.util.Arrays;


class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            ArrayList<Integer> answer = new ArrayList<>();

            int days = 0;
            int finishCnt = 0;

            for (int i = 0; i < progresses.length; i++) {

                int workDays = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);

                if (workDays > days) {
                    if (finishCnt > 0) {
                        answer.add(finishCnt);
                    }
                    days = workDays;
                    finishCnt = 1;
                } else {
                    finishCnt++;
                }
            }

                answer.add(finishCnt);
            
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

