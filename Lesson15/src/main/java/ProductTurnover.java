public interface ProductTurnover<T> {
    void addProduct(T product);

    void orderProduct(T product);

    void deleteProduct(T product);
}
