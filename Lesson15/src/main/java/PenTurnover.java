public class PenTurnover implements ProductTurnover<Pen> {


    @Override
    public void addProduct(Pen product) {
        System.out.println("add_Pen: " + product);
    }

    @Override
    public void orderProduct(Pen product) {
        System.out.println("order_Pen: " + product);
    }

    @Override
    public void deleteProduct(Pen product) {
        System.out.println("delete_Pen: " + product);
    }
}
