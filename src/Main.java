import model.Person;
import sort.QuickSort;
import tuple.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person[] people = {
                new Person(123, 23, 3),
                new Person(163, 64, 23),
                new Person(110, 16, 4),
                new Person(15, 23, 53),
                new Person(163, 64, 14),
                new Person(123, 23, 16),
                new Person(131, 99, 32),
                new Person(176, 64, 41),
                new Person(121, 32, 11),
                new Person(100, 10, 1)};


        QuickSort.sort(people, Comparator.comparing(Person::getAge));
        System.out.println(Arrays.toString(people));
        QuickSort.sort(people, Comparator.comparing(Person::getWeight));
        System.out.println(Arrays.toString(people));
        QuickSort.sort(people, Comparator.comparing(Person::getHeight));
        System.out.println(Arrays.toString(people));

        System.out.println("Counted people with same weight and different height");
        System.out.println("Weight - People quantity");
        System.out.println(countPeopleWithSameWeightAndDiffHeight(people));


    }

    public static List<Tuple<Integer, Integer>> countPeopleWithSameWeightAndDiffHeight(Person[] people) {

        Arrays.sort(people, Comparator.comparing(Person::getWeight).thenComparing(Person::getHeight));

        List<Tuple<Integer, Integer>> peopleWithDiffHeightSameWeight = new ArrayList<>();
        Person temp = people[0];
        int count = 1;

        for (Person person : people) {
            if (person.getWeight() == temp.getWeight()) {
                if (person.getHeight() != temp.getHeight()) {
                    count++;
                }
            } else {
                peopleWithDiffHeightSameWeight.add(new Tuple<>(temp.getWeight(), count));
                count = 1;
            }
            temp = person;
        }
        peopleWithDiffHeightSameWeight.add(new Tuple<>(temp.getWeight(), count));


        return peopleWithDiffHeightSameWeight;
    }

    
}