public abstract class Worker implements Comparable {
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

    public String getFirstName() {
        return firstName;
    }

    public Position.TypeOfPosition getTypeOfPosition() {
        return typeOfPosition;
    }

    @Override
    public int compareTo(Object o) {
        if (countSalary() == ((Worker) o).countSalary())
            if (firstName.equals(((Worker) o).firstName)) return 0;
        if (countSalary() > ((Worker) o).countSalary()) return -1;
        else return 1;
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
                ", Salary=" + countSalary() +
                '}' + "\n";
    }
}
