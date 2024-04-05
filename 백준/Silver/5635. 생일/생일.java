
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            String[] info = br.readLine().split(" ");
            String name = info[0];
            int day = Integer.parseInt(info[1]);
            int month = Integer.parseInt(info[2]);
            int year = Integer.parseInt(info[3]);
            people[i] = new Person(name, day, month, year);
        }

        Arrays.sort(people); // 나이순으로 정렬

        // 가장 어린 학생과 가장 나이가 많은 학생 출력
        System.out.println(people[n - 1].name);
        System.out.println(people[0].name);
    }

    static class Person implements Comparable<Person> {
        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Person o) {
            if (this.year != o.year) return this.year - o.year;
            if (this.month != o.month) return this.month - o.month;
            return this.day - o.day;
        }
    }
}
