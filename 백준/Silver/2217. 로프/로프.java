import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        
        // N개의 로프 중량 입력받기
        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        
        // 로프의 중량을 오름차순으로 정렬함
        Arrays.sort(ropes);
        
        int maxWeight = 0;
        
        for (int i = 0; i < N; i++) {
            // ropes[i]를 포함하여 그보다 튼튼한 로프들을 모두 사용했을 때의 최대 중량 계산
            // 사용할 수 있는 로프의 개수 = 전체 로프 개수(N) - 현재 인덱스(i)
            int currentWeight = ropes[i] * (N - i);
            
            // 기존의 최댓값보다 크면 갱신함
            if (maxWeight < currentWeight) {
                maxWeight = currentWeight;
            }
        }
        
        // 최종적으로 가장 무거운 중량을 출력함
        System.out.println(maxWeight);
    }
}