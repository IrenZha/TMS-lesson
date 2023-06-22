import java.util.ArrayList;

public class Person {
    private String login;
    private String name;
    private int age;
   private Gender gender;
  private ArrayList<Child> children = new ArrayList<>();

    public Person(String login, String name, int age, Gender gender) {
        this.login = login;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void addChild(Child child){
        children.add(child);
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
           //     ", children=" + children +
                '}';
    }
}
