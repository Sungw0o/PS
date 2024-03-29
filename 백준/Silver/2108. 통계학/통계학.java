import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		double sum = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		//정렬
		Arrays.sort(arr);
		
		int count = 0;
		int max = -1;
		//for문 한개로 돌리는 방식이기에 값이 1개이면 반복문이 돌지 않는다.
		//그렇기에 처음 최빈값은 배열의 첫번째 값으로 저장해 준다.
		int mod = arr[0];
		boolean check = false;
		//최빈값 구하는 반복문
		for(int i = 0; i < N - 1; i++) {
			if(arr[i] == arr[i + 1]) {
				count++;
			}else {
				count = 0;
			}
			
			if(max < count) {
				max = count;
				mod = arr[i];
				check = true;
			}else if(max == count && check == true) {
				mod = arr[i];
				check = false;
			}
		}
		System.out.println(Math.round(sum / N));
		System.out.println(arr[(N - 1) / 2]);
		System.out.println(mod);
		System.out.println(arr[N - 1] - arr[0]);
	}

}