import java.util.*;

class Solution {
    private List<String> result = new ArrayList<>();
    private boolean[] visited;
    private String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));

        visited = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN"); 
        dfs(tickets, "ICN", path, 0);

        return answer; 
    }

    private void dfs(String[][] tickets, String current, List<String> path, int depth) {
        if (depth == tickets.length) {
            if (answer == null) {
                answer = path.toArray(new String[0]);
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true; 
                path.add(tickets[i][1]); 
                dfs(tickets, tickets[i][1], path, depth + 1);
                path.remove(path.size() - 1); 
                visited[i] = false; 
            }
        }
    }
}
