package abstractFactory;

public class SculptureWarehouseService implements WarehouseService{
    @Override
    public void toWarehouse() {
        System.out.println("Sculpture to Warehouse");
    }
}
