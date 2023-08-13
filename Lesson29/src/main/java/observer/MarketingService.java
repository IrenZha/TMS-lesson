package observer;

import java.util.Observable;
import java.util.Observer;

public class MarketingService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Marketing - discounted product " + o);
    }
}
