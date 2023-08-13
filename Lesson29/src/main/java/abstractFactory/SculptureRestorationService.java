package abstractFactory;

public class SculptureRestorationService implements RestorationService{
    @Override
    public void toRestoration() {
        System.out.println("Sculpture to the Restoration");
    }
}
