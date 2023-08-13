package abstractFactory;

public class PictureWarehouseService implements WarehouseService{
    @Override
    public void toWarehouse() {
        System.out.println("Picture to the Warehouse");
    }
}
