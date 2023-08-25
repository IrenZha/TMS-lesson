package abstractFactory;

public class SculptureFactory implements MuseumAbstractFactory{
    @Override
    public RestorationService getRestorationService() {
        return new SculptureRestorationService();
    }

    @Override
    public ExhibitionService getExhibitionService() {
        return new SculptureExhibitionService();
    }

    @Override
    public WarehouseService getWarehouseService() {
        return new SculptureWarehouseService();
    }
}
