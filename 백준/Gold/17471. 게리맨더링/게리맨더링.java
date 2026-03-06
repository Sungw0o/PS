
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, minDiff;
    private static ArrayList<Integer>[] graph;
    private static int[] population;
    private static boolean[] isSelected;
    
    private static StringBuilder sb;


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[N + 1];
        population = new int[N + 1];
        isSelected = new boolean[N + 1];
        minDiff = Integer.MAX_VALUE;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            population[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int adjCnt = Integer.parseInt(st.nextToken());
            
            for (int j = 1; j <= adjCnt; j++) {
                int u = Integer.parseInt(st.nextToken());
                graph[i].add(u);
            }
        }
        
        divide(1);
        
       
        minDiff = minDiff == Integer.MAX_VALUE ? -1 : minDiff;
        sb.append(minDiff);
        
        System.out.println(sb);
        br.close();
    }
    
    public static void divide(int idx) {
    	
    	if(idx == N + 1) {
    		ArrayList<Integer> aList = new ArrayList<>();
    		ArrayList<Integer> bList = new ArrayList<>();
    		
    		for(int i = 1; i<= N; i++) {
    			if(isSelected[i]) aList.add(i);
    			else bList.add(i);
    		}
    		
    		if(aList.isEmpty() || bList.isEmpty()) return;
    		
    		if(isConnected(aList) && isConnected(bList)) {
    			
    			int aSum = 0;
    			int bSum = 0;
    			
    			for(int i : aList) {
    				aSum += population[i];
    			}
    			
    			for(int i : bList) {
    				bSum += population[i];
    			}
    			
    			minDiff = Math.min(minDiff, Math.abs(aSum-bSum));
    		}
    		return;
    	}
        
        isSelected[idx] = true;
        divide(idx + 1);
        isSelected[idx] = false;
        divide(idx + 1);
        
       
    }
    
    public static boolean isConnected(ArrayList<Integer> list) {
    	
    	if(list.isEmpty()) return false;
    	
    	Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        
        int start = list.get(0);
        q.add(start);
        visited[start] = true;
        
        int count = 1;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                if (!visited[next] && list.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        
        return count == list.size();
    }
}