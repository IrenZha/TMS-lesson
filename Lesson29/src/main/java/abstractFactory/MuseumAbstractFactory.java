package abstractFactory;

public interface MuseumAbstractFactory {
    RestorationService getRestorationService();

    ExhibitionService getExhibitionService();

    WarehouseService getWarehouseService();
}
