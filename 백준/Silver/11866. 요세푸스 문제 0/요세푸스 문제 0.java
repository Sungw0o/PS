import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        int K = scanner.nextInt(); 

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

   
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int person = queue.poll(); 
            if (count % K == 0) {
                result.add(person); 
            } else {
                queue.add(person); 
            }
        }

    
        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");
    }
}
