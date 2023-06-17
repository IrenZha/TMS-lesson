public class Worker {
    private String firstName;
    private String lastName;
    private Gender gender;
    private int experience;
    private Position.TypeOfPosition typeOfPosition;

    public enum Gender {
        MALE,
        FEMALE
    }

    public Worker(String firstName, String lastName, int experience, Gender gender, Position.TypeOfPosition typeOfPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.experience = experience;
        this.typeOfPosition = typeOfPosition;
    }

    public double countSalary() {
        //   for testing:
        //   System.out.print("Salary = " + typeOfPosition.getPositionCoefficient() + " * (" + experience + " + 1) = ");
        return typeOfPosition.getPositionCoefficient() * (experience + 1);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", experience=" + experience +
                ", Position=" + typeOfPosition +
                "_" + typeOfPosition.getPosition() +
                '}' + "\n";
    }
}
