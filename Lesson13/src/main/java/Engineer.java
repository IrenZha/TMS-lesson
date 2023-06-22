public class Engineer extends Worker{
    public Engineer(String firstName, String lastName, int experience, Gender gender, Position.TypeOfPosition typeOfPosition) {
        super(firstName, lastName, experience, gender, typeOfPosition);
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
}
