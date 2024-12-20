import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] people = new Person[n];
        
        for (int i = 0; i < n; i++) {
            String[] perInfo = br.readLine().split(" ");
            int height = Integer.parseInt(perInfo[0]);
            int weight = Integer.parseInt(perInfo[1]);
            people[i] = new Person(height, weight);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && people[i].isSmallerThan(people[j])) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }
        
        System.out.println(sb);
        br.close();
    }
    
    static class Person {
        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        public boolean isSmallerThan(Person other) {
            return this.height < other.height && this.weight < other.weight;
        }
    }
}
