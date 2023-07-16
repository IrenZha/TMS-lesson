public interface TableService<T> {
    void create();

    void update(T parameter);

    void insert(T parameter);

    void delete(int id);

    void readTable();

    boolean isContains(int id);

}
