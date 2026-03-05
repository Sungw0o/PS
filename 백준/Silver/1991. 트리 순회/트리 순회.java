
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int N;
	private static int[][] tree = new int[26][2];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< N ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = st.nextToken().charAt(0) -'A';
			int left = st.nextToken().charAt(0);
			left = left == '.' ? -1 : left -'A';
			
			int right = st.nextToken().charAt(0);
			right = right == '.' ? -1 : right-'A';
			
			tree[parent][0] = left;
			tree[parent][1] = right;
		}
		
		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
			
		br.close();
	}
	
	public static void preOrder(int cur) {
		if(cur==-1) return;
		System.out.print((char) (cur +'A'));
		preOrder(tree[cur][0]);
		preOrder(tree[cur][1]);
	}
	
	public static void inOrder(int cur) {
		if(cur == -1) return;
		inOrder(tree[cur][0]);
		System.out.print((char) (cur +'A'));
		inOrder(tree[cur][1]);
	}
	
	public static void postOrder(int cur) {
		if(cur == -1) return;
		postOrder(tree[cur][0]);
		postOrder(tree[cur][1]);
		System.out.print((char) (cur +'A'));
	}
}
