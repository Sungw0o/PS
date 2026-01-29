import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static Station[] stations = new Station[1000001];

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		

		Station head = null;
		Station tail = null;
		
		for(int i = 0; i< N;i++)
		{
			int stNum = Integer.parseInt(st.nextToken());
			
			Station station = new Station(stNum);
			stations[stNum] = station;
			
			if(head == null) {
				head = station;
				tail = station;
			}
			
			else {
				tail.next = station;
				station.prev = tail;
				tail = station;
			}
		}
		
		if (tail != null && head != null) {
            tail.next = head;
            head.prev = tail;
        }
		
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int stNum = Integer.parseInt(st.nextToken());
			int newStNum = 0;
			
			Station cur = stations[stNum];
			
			switch (cmd) {
				
				case "BN":
					newStNum = Integer.parseInt(st.nextToken());
					sb.append(cur.next.num).append("\n");
					Station next = cur.next;
					Station newNext = new Station(newStNum);
					
					stations[newStNum] = newNext;
                    
                    cur.next = newNext;
                    newNext.prev = cur;
                    newNext.next = next;
                    next.prev = newNext;
                    break;
					
				case "BP":
					newStNum = Integer.parseInt(st.nextToken());
					sb.append(cur.prev.num).append("\n");
					Station prev = cur.prev;
					Station newPrev = new Station(newStNum);
					
					stations[newStNum] = newPrev;
                    
                    cur.prev = newPrev;
                    newPrev.next = cur;
                    newPrev.prev = prev;
                    prev.next = newPrev;
                    break;
                    
				case "CP":
                    Station targetPrev = cur.prev;
                    sb.append(targetPrev.num).append("\n");
                    
                    Station pullSt2 = targetPrev.prev;
                    cur.prev = pullSt2;
                    pullSt2.next = cur;
                    
                    stations[targetPrev.num] = null; 
                    break;
                    
				case "CN":
					Station targetNext = cur.next;
                    sb.append(targetNext.num).append("\n");
                    
                    Station pullSt = targetNext.next;
                    cur.next = pullSt;
                    pullSt.prev = cur;
                    
                    stations[targetNext.num] = null; 
                    break;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static class Station{
		
		int num;
		public Station prev;
		public Station next;
		
		public Station(int num) {
			this.num = num;
		}
	}
}
