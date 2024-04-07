import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrayA = new int[n];
        int[] arrayB = new int[m];

        // 배열 A 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 병합 후 정렬
        int[] mergedArray = mergeArrays(arrayA, arrayB);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : mergedArray) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }

    // 배열 병합 및 정렬
    private static int[] mergeArrays(int[] arrayA, int[] arrayB) {
        int[] mergedArray = new int[arrayA.length + arrayB.length];
        int indexA = 0, indexB = 0, indexMerged = 0;

        // 배열 A와 배열 B의 요소를 비교하면서 작은 값을 병합 배열에 추가
        while (indexA < arrayA.length && indexB < arrayB.length) {
            if (arrayA[indexA] <= arrayB[indexB]) {
                mergedArray[indexMerged++] = arrayA[indexA++];
            } else {
                mergedArray[indexMerged++] = arrayB[indexB++];
            }
        }

        // 배열 A나 배열 B 중 남은 요소들을 병합 배열에 추가
        while (indexA < arrayA.length) {
            mergedArray[indexMerged++] = arrayA[indexA++];
        }
        while (indexB < arrayB.length) {
            mergedArray[indexMerged++] = arrayB[indexB++];
        }

        return mergedArray;
    }
}
