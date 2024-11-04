import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


class Solution {
        public static void main(String args[]) throws Exception {

            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int T;
            T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    int num = sc.nextInt();
                    arrayList.add(num);
                }
                int result = (int) avg(arrayList);
                sb.append("#"+test_case+" "+result+"\n");
            }
            sc.close();
            System.out.println(sb);
        }
        public static double avg(ArrayList<Integer> list){
            list.remove(Collections.max(list));
            list.remove(Collections.min(list));

            double sum = 0;
            for(Integer num : list){
                sum += num;
            }

            return (int) Math.round(sum / list.size());

        }
    }