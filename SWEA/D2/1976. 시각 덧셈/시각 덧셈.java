import java.util.Scanner;

class Solution {
        public static void main(String args[]) throws Exception {

            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                int aHours = sc.nextInt();
                int aMinutes = sc.nextInt();
                int bHours = sc.nextInt();
                int bMinutes = sc.nextInt();

                int[] time = calcHour(aHours, aMinutes, bHours, bMinutes);
                
                sb.append("#").append(test_case).append(" ").append(time[0]).append(" "+time[1]).append("\n");
            }
            
            System.out.print(sb);
            sc.close();
        }

        public static int[] calcHour(int aH, int aM, int bH, int bM){
            int hour = aH + bH;
            int minute = aM + bM;
            
            if (minute >= 60) {
                hour += minute / 60;  
                minute = minute % 60; 
            }
            
            hour %= 12;
            if (hour == 0) { // 수정
                hour = 12; 
            }
            
            return new int[]{hour, minute};
        }
    }