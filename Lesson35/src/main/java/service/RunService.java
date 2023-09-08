package service;

import domain.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@Service
public class RunService {
    private List<Pair> pairs;

    public void printMassageInfo() {
        int j = 0;
        while (j < pairs.size()) {
            System.out.println((j + 1) + " " + pairs.get(j) + ", speed: " + Math.round(pairs.get(j).getSpeed()));
            j++;
        }
        System.out.println("-----------------------------------------------");
    }
    @SneakyThrows
    public void printMassageStart() {
        System.out.println("-----------------------------------------------");
        System.out.println("                      3");
        Thread.sleep(1000);
        System.out.println("                      2");
        Thread.sleep(1000);
        System.out.println("                      1");
        Thread.sleep(1000);
        System.out.println("--------------------START---------------------");
    }
    public void printMassageFinish() {
        System.out.println("--------------------FINISH---------------------");
        System.out.println();
        System.out.println("Winner: " + getWinner());
    }

    public Pair getWinner() {
        int indexOfWinner = 0;
        for (int i = 1; i < pairs.size(); i++) {
            if (pairs.get(i).getSpeed() > pairs.get(indexOfWinner).getSpeed())
                indexOfWinner = i;
        }
        return pairs.get(indexOfWinner);
    }
    @SneakyThrows
    public void run() {
        int i = 1;
        while (i <= 5) {
            Thread.sleep(2000);
            for (Pair pair : pairs) {
                pair.setTime();
                System.out.println(pair + ", Time: " + Math.round(pair.getTime()));
            }
            System.out.println("-------------------Circle "+ i +"--------------------");
            System.out.println("Winner: " + getWinner());
            System.out.println("-----------------------------------------------");
            i++;
        }
    }
    public boolean isVictory(int pairNumber){
      return getWinner().equals(pairs.get(pairNumber-1));
    }
}
