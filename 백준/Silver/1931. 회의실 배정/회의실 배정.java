
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting m){
        if(m.end== this.end) return this.start - m.start;
        return this.end -m.end;
    }
    @Override
    public String toString() {
        return "(" + this.start + ", " + this.end + ")";
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Meeting> queue = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            queue.offer(new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int answer = 1;
        Meeting prev = queue.poll();
        while(!queue.isEmpty()){
            Meeting temp = queue.poll();
            if(prev.end <= temp.start){
                answer++;
                prev=temp;
            }
        }
        System.out.println(answer);
    }
}
