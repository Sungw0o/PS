import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	private static int N, Q;
	private static TreeSet<Integer> place = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int isAttraction = Integer.parseInt(st.nextToken());
			if (isAttraction == 1) {
				place.add(i);
			}
		}
		
		int pos = 1; 
		
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			
			switch (type) {
				case 1:
					int target = Integer.parseInt(st.nextToken());
					if(place.contains(target)) {
						place.remove(target);
					}
					else {
						place.add(target);
					}
					break;
					
				case 2:
					int x = Integer.parseInt(st.nextToken());
					pos = (pos - 1 + x) % N + 1;
					break;
					
				case 3:
					if (place.isEmpty()) {
						sb.append(-1).append("\n");
					} else {
						Integer pNum = place.ceiling(pos);
						
						if(pNum != null) {
							sb.append(pNum - pos).append("\n");
						} else {

							int distance = (N - pos) + place.first();
							sb.append(distance).append("\n");
						}
					}
					break;
			}
		}
		
		System.out.print(sb);
		br.close();
	}
}