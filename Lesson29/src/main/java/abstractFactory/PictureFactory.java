package abstractFactory;

public class PictureFactory implements MuseumAbstractFactory{
    @Override
    public RestorationService getRestorationService() {
        return new PictureRestorationService();
    }

    @Override
    public ExhibitionService getExhibitionService() {
        return new PictureExhibitionService();
    }

    @Override
    public WarehouseService getWarehouseService() {
        return new PictureWarehouseService();
    }
}
