
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i< N ;i++) {
			
			Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();
			
			char[] arr = br.readLine().toCharArray();
			for(char c : arr) {
                switch(c) {
                case '<': 
                    if(!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case '>': 
                    if(!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;
                case '-': 
                    if(!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                default: 
                    left.addLast(c);
                    break;
                }
            }
            
            for(char c : left) {
                bw.write(c);
            }
            for(char c : right) {
                bw.write(c);
            }
            bw.write("\n"); 
		}
		
		bw.flush();
		bw.close();
		br.close();

	}
}
