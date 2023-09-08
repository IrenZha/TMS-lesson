package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private int wallet;

    public void setResultWallet(int bet, boolean isVictory) {
        if (isVictory) {
            wallet += bet;
            System.out.println("------------------! VICTORY !-------------------");
        } else {
            wallet -= bet;
            System.out.println("------------------!   UPS   !-------------------");
        }
    }
}
