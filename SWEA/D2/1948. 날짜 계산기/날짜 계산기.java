
import java.util.Scanner;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution {
        public static void main(String args[]) throws Exception {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int T = sc.nextInt();
            
            int year = 2023;

            for (int test_case = 1; test_case <= T; test_case++) {
                int month1 = sc.nextInt();
                int day1 = sc.nextInt();
                int month2 = sc.nextInt();
                int day2 = sc.nextInt();
                
                LocalDate date1 = LocalDate.of(year, month1, day1);
                LocalDate date2 = LocalDate.of(year, month2, day2);
                
                long daysBetween = ChronoUnit.DAYS.between(date1, date2)+1;
                
                sb.append("#").append(test_case).append(" ").append(Math.abs(daysBetween)).append("\n");
            }

            sc.close();
            System.out.println(sb);
        }
    }