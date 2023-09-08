package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
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
