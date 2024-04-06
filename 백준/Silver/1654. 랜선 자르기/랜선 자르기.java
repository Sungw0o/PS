

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long[] arr;
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        n = Long.parseLong(input[1]);
        arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long start = 1; // 랜선의 길이는 최소 1부터 시작
        long end = arr[k - 1];
        long answer = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            if (countLanCables(mid) >= n) { // 만들 수 있는 랜선의 개수가 목표보다 크거나 같으면
                answer = mid; // 현재 길이를 기록하고
                start = mid + 1; // 길이를 늘려서 더 큰 길이로 시도
            } else { // 목표보다 작으면
                end = mid - 1; // 길이를 줄여서 더 작은 길이로 시도
            }
        }

        System.out.println(answer);
    }

    // 주어진 길이로 만들 수 있는 랜선의 개수 계산
    static long countLanCables(long length) {
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i] / length;
        }
        return count;
    }
}
