import java.util.Collections;
import java.util.PriorityQueue;


class Solution {
        static PriorityQueue<Integer> maxqp = new PriorityQueue<>(Collections.reverseOrder());
        static PriorityQueue<Integer> minqp = new PriorityQueue<>();
        public int[] solution(String[] operations) {
            for(String op : operations){
                function(op);
            }

            int max = maxqp.isEmpty() ? 0 : (maxqp.poll());
            int min = minqp.isEmpty() ? 0 : (minqp.poll());
            int[] answer = {max,min};
            return answer;
        }

        public void function(String op){
            if(op.contains("I")){
                int num = Integer.parseInt(op.split(" ")[1]);
                maxqp.add(num);
                minqp.add(num);
            }
            else if(!maxqp.isEmpty() && !minqp.isEmpty()){
                if(op.equals("D 1")){
                    int max = maxqp.poll();
                    minqp.remove(max);
                }
                else if(op.equals("D -1")){
                    int min = minqp.poll();
                    maxqp.remove(min);
                }
            }
        }
    }