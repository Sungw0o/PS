import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] prev = new int[1000001];
	static int[] next = new int[1000001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int firstSt = Integer.parseInt(st.nextToken());
		int currentSt = firstSt;
		
		for(int i = 1; i < N; i++) {
			int nextSt = Integer.parseInt(st.nextToken());
			
			next[currentSt] = nextSt;
			prev[nextSt] = currentSt;
			
			currentSt = nextSt;
		}
		
		next[currentSt] = firstSt;
		prev[firstSt] = currentSt;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int cur = Integer.parseInt(st.nextToken());
			
			switch (cmd) {
				case "BN":
					int newStBN = Integer.parseInt(st.nextToken());
					int nextNode = next[cur];
					sb.append(nextNode).append("\n");
					
					prev[newStBN] = cur;
					next[newStBN] = nextNode;
					next[cur] = newStBN;
					prev[nextNode] = newStBN;
					break;
					
				case "BP":
					int newStBP = Integer.parseInt(st.nextToken());
					int prevNode = prev[cur];
					sb.append(prevNode).append("\n");
					
					prev[newStBP] = prevNode;
					next[newStBP] = cur;
					next[prevNode] = newStBP;
					prev[cur] = newStBP;
					break;
					
				case "CN":
					int targetN = next[cur];
					sb.append(targetN).append("\n");
					
					int nnNode = next[targetN];
					next[cur] = nnNode;
					prev[nnNode] = cur;
					break;
					
				case "CP":
					int targetP = prev[cur];
					sb.append(targetP).append("\n");
					
					int ppNode = prev[targetP];
					next[ppNode] = cur;
					prev[cur] = ppNode;
					break;
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}