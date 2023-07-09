public abstract class Products {
    private double price;
    private int numberOfPieces;

    public Products() {
    }

    public Products(double price, int numberOfPieces) {
        this.price = price;
        this.numberOfPieces = numberOfPieces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfPieces() {
        return numberOfPieces;
    }

    public void setNumberOfPieces(int numberOfPieces) {
        this.numberOfPieces = numberOfPieces;
    }

    @Override
    public String toString() {
        return "Products{" +
                "price=" + price +
                ", numberOfPieces=" + numberOfPieces +
                '}';
    }
}
