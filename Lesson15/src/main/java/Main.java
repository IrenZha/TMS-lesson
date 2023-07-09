public class Main {
    public static void main(String[] args) {
        ProductTurnover<Pen> penProductTurnover = new PenTurnover();
        Pen pen = new Pen(1.5, 30, "Red");
        penProductTurnover.addProduct(new Pen(1.0, 20, "Black"));
        penProductTurnover.addProduct(pen);
        penProductTurnover.orderProduct(new Pen(2.0, 100, "Blue"));
        penProductTurnover.deleteProduct(pen);

        ProductTurnover<Pencil> pencilProductTurnover = new PencilTurnover();
        Pencil pencil1 = new Pencil(0.5, 200, "Grey", Pencil.Hardness.H);
        Pencil pencil2 = new Pencil(0.7, 150, "Grey", Pencil.Hardness.HB);
        pencilProductTurnover.addProduct(pencil1);
        pencilProductTurnover.orderProduct(pencil1);
        pencilProductTurnover.deleteProduct(pencil2);
    }
}
