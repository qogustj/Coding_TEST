package start;

import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {
    String name;
    double height;

    Person(String name, double height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(Person other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare == 0) {
            return Double.compare(this.height, other.height);
        }
        return nameCompare;
    }
}

public class sort_lv1구름출석부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double height = Double.parseDouble(st.nextToken());
            people.add(new Person(name, height));
        }

        Collections.sort(people);

        Person kthPerson = people.get(K - 1);
        System.out.printf("%s %.2f\n", kthPerson.name, kthPerson.height);
    }
}
