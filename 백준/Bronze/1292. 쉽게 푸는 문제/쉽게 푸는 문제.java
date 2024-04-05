

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // 수열 생성
        int[] arr = new int[b * (b + 1) / 2]; // 수열을 저장할 배열
        int index = 0; // 배열 인덱스
        for (int i = 1; i <= b; i++) {
            for (int j = 0; j < i; j++) {
                arr[index++] = i;
                if (index >= arr.length) break; // 배열 범위를 초과하면 종료
            }
            if (index >= arr.length) break; // 배열 범위를 초과하면 종료
        }

        // a부터 b까지의 합 계산
        int sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
