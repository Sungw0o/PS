import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int C = Integer.parseInt(st.nextToken()); 

        int M = Integer.parseInt(br.readLine()); 
        int ans = 0;

        Truck[] trucks = new Truck[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sendTown = Integer.parseInt(st.nextToken());
            int recvTown = Integer.parseInt(st.nextToken());
            int boxes = Integer.parseInt(st.nextToken());

            trucks[i] = new Truck(sendTown, recvTown, boxes);
        }

        Arrays.sort(trucks, (a, b) -> a.recvTown == b.recvTown ? a.sendTown - b.sendTown : a.recvTown - b.recvTown);

        int[] load = new int[N + 1];

        for (Truck truck : trucks) {
            int maxLoad = 0;
            
            for (int i = truck.sendTown; i < truck.recvTown; i++) {
                maxLoad = Math.max(maxLoad, load[i]);
            }
            
            int canLoad = Math.min(truck.boxes, C - maxLoad);
            
            ans += canLoad;
            for (int i = truck.sendTown; i < truck.recvTown; i++) {
                load[i] += canLoad;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Truck {
        int sendTown;
        int recvTown;
        int boxes;

        public Truck(int sendTown, int recvTown, int boxes) {
            this.sendTown = sendTown;
            this.recvTown = recvTown;
            this.boxes = boxes;
        }
    }
}
