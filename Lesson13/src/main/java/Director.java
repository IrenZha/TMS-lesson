import java.util.ArrayList;

public class Director extends Worker {
    int countSubordinates = 0;
    private ArrayList<Worker> subordinates = new ArrayList<>();
    static boolean contains = false;

    public Director(String firstName, String lastName, int experience, Gender gender, Position.TypeOfPosition typeOfPosition) {
        super(firstName, lastName, experience, gender, typeOfPosition);
    }

    public void assignSubordinates(Worker worker) {
        subordinates.add(worker);
        countSubordinates = subordinates.size();
    }

    public static boolean isSubordinates(Director director, Worker worker) {
        return director.subordinates.contains(worker);
    }


    public static boolean isSubordinatesAll(Director director, Worker worker) {
        if (!director.subordinates.contains(worker)) {
            for (Worker myWorker : director.subordinates) {
                if (myWorker.getClass() == Director.class) {
                    director = (Director) myWorker;
                    isSubordinatesAll(director, worker);
                }
            }
        } else contains = true;
        return contains;
    }


    static void toStringAll(Director director) {
        System.out.println("=================================================================================================");
        System.out.print("  ***  " + director);
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println(director.subordinates);
        for (Worker myWorker : director.subordinates) {
            if (myWorker.getClass() == Director.class) {
                director = (Director) myWorker;
                toStringAll(director);
            }
        }
    }

    @Override
    public double countSalary() {
        //   for testing:
        //   System.out.print("Bonus = "+ countSubordinates + " * 500 + ");
        return super.countSalary() + countSubordinates * 500;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Subordinates = " + countSubordinates + "\n";
    }


}