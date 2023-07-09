public class PencilTurnover implements ProductTurnover<Pencil> {


    @Override
    public void addProduct(Pencil product) {
        System.out.println("add_PenciL: " + product);
    }

    @Override
    public void orderProduct(Pencil product) {
        System.out.println("order_Pencil: " + product);
    }

    @Override
    public void deleteProduct(Pencil product) {
        System.out.println("delete_Pencil: " + product);
    }
}
