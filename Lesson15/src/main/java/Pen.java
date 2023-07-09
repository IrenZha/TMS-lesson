public class Pen extends Products {
    private String inkColor;

    public Pen() {
    }

    public Pen(double price, int numberOfPieces, String inkColor) {
        super(price, numberOfPieces);
        this.inkColor = inkColor;
    }

    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    @Override
    public String toString() {
        return super.toString() +
                " inkColor='" + inkColor + '\'' +
                '}';
    }
}
