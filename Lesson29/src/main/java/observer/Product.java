package observer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Observable;

@Data
@AllArgsConstructor
public class Product extends Observable {
    private String name;
    int price;

    public void setDiscount(int discount) {
        this.price = price - (price * discount / 100);
        setChanged();
        notifyObservers();

    }

}
