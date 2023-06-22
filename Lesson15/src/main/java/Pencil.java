public class Pencil extends Products {
    private String color;

   public enum Hardness {
        B,
        HB,
        F,
        H
    }

    public Pencil() {
    }

    public Pencil(double price, int numberOfPieces, String color,Hardness hardness) {
        super(price, numberOfPieces);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() +
                " color=" + getColor()+ '\'' +
                '}';
    }
}
