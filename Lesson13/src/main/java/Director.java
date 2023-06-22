import java.util.ArrayList;

public class Director extends Worker {

    private ArrayList<Worker> subordinates = new ArrayList<>();

    public Director(String firstName, String lastName, int experience, Gender gender, Position.TypeOfPosition typeOfPosition) {
        super(firstName, lastName, experience, gender, typeOfPosition);
    }

    public void assignSubordinates(Worker worker) {
        subordinates.add(worker);
    }

    public boolean isSubordinates(String workerName) {
        for (Worker workers : subordinates) {
            if (workers.getFirstName().equals(workerName)) return true;
        }
        return false;
    }

    public boolean isSubordinatesAll(String workerName) {
        for (Worker workers : subordinates) {
            if (workers.getFirstName().equals(workerName)) return true;
        }
        for (Worker worker : subordinates) {
            if ((worker.getTypeOfPosition().getPosition() == Position.DIRECTOR) && (!worker.getFirstName().equals(workerName))) {
                ((Director) worker).isSubordinatesAll(workerName);
            } else return true;
        }
        return false;
    }

    @Override
    public double countSalary() {
        //   for testing:
        //   System.out.print("Bonus = "+ countSubordinates + " * 500 + ");
        return super.countSalary() + subordinates.size() * 500;
    }
/*
    @Override
    public String toString() {
        return "Director{" +
                "subordinates=" + "\n" +
                subordinates + '}';
    }
*/
    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
}