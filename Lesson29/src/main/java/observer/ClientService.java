package observer;

import java.util.Observable;
import java.util.Observer;

public class ClientService implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Client - discounted product " + o);
    }
}
