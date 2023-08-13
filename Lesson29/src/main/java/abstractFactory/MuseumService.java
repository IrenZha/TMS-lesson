package abstractFactory;

public class MuseumService {
    public void makeSchedule(MuseumAbstractFactory factory){
        factory.getExhibitionService().toExhibition();
        factory.getRestorationService().toRestoration();
        factory.getWarehouseService().toWarehouse();
    }
}
