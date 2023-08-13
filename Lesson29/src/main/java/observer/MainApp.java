package observer;

public class MainApp {
    public static void main(String[] args) {
        Product product = new Product("laptop", 5000);
        product.addObserver(new ClientService());
        product.addObserver(new MarketingService());
        product.setDiscount(20);
        product.setDiscount(30);

    }
}
