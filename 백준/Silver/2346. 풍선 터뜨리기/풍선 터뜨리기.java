import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Ballon head = null;
        Ballon tail = null;
        
        for(int i = 0; i < N; i++) {
            int paper = Integer.parseInt(st.nextToken());
            Ballon newBallon = new Ballon(i + 1, paper); 

            if (head == null) {
                head = newBallon;
                tail = newBallon;
            } else {
                tail.next = newBallon; 
                newBallon.prev = tail;
                tail = newBallon;
            }
        }
        
        if(N>0) {
        	tail.next = head;
        	head.prev = tail;
        }
        
        Ballon cur = head;
        
        for(int i = 0; i< N ; i++) {
        	bw.write(cur.num+" ");
        	
        	int mvVal = cur.paper;
        	
        	cur.prev.next = cur.next;
        	cur.next.prev = cur.prev;
        	
        	if(mvVal > 0) {
        		cur = cur.next;
        		for(int j = 0; j < mvVal -1 ; j++) {
        			cur = cur.next;
        		}
        	} else {
        		cur = cur.prev;
        		int steps = Math.abs(mvVal);
        		for(int j = 0; j < steps - 1; j++) { 
        			cur = cur.prev;
        		}
        	}
        }
                
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Ballon{
    	
    	public int num;
    	public int paper;
    	public Ballon next;
    	public Ballon prev;
    	
    	public Ballon(int num, int paper) {
    		this.num = num;
    		this.paper = paper;
    	}
    }
}

