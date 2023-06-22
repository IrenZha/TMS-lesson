import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Person person1 = new Person("login1", "Ivan", 45, Gender.MALE);
        Person person2 = new Person("login2", "Petr", 25, Gender.MALE);
        Person person3 = new Person("login3", "Dan", 40, Gender.MALE);
        Person person4 = new Person("login4", "Max", 30, Gender.MALE);
        Person person5 = new Person("login5", "Anna", 28, Gender.FEMALE);
        Person person6 = new Person("login6", "Inga", 22, Gender.FEMALE);
        Person person7 = new Person("login7", "Mari", 40, Gender.FEMALE);
        Person person8 = new Person("login8", "Olga", 37, Gender.FEMALE);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);
        people.add(person8);
        Child child1 = new Child("Dima", 5, Gender.MALE);
        Child child2 = new Child("Vlad", 3, Gender.MALE);
        person2.addChild(child1);
        person2.addChild(child2);
        person6.addChild(child1);
        person6.addChild(child2);

        Child child3 = new Child("Marina", 17, Gender.FEMALE);
        Child child4 = new Child("Oksana", 15, Gender.FEMALE);
        Child child5 = new Child("Igor", 10, Gender.MALE);
        person1.addChild(child3);
        person1.addChild(child4);
        person1.addChild(child5);
        person7.addChild(child3);
        person7.addChild(child4);
        person7.addChild(child5);

        Child child6 = new Child("Marta", 8, Gender.FEMALE);
        person3.addChild(child6);
        person8.addChild(child6);

        Child child7 = new Child("Slava", 4, Gender.MALE);
        person4.addChild(child7);
        person5.addChild(child7);

        List<Person> genderMale = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .collect(Collectors.toList());
        System.out.println(genderMale);

        List<Person> numberOfChildren = people.stream()
                .filter(person -> person.getChildren().size() > 2)
                .collect(Collectors.toList());
        System.out.println(numberOfChildren);

        List<String> childrenAge = people.stream()
                .flatMap(person -> person.getChildren().stream())
                .filter(child -> child.getAge() < 6)
                .map(Child::getName)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(childrenAge);

        List<Person> genderFmMale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.filtering(person -> person.getChildren().stream()
                        .allMatch(child -> child.getAge() < 12), Collectors.toList()));
        System.out.println(genderFmMale);

        List<Integer> allAge = people.stream()
                .flatMap(person -> person.getChildren().stream())
                .map(Child::getAge)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(allAge);
    }
}
