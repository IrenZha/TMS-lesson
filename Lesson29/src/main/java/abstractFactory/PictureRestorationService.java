package abstractFactory;

public class PictureRestorationService implements RestorationService{

    @Override
    public void toRestoration() {
        System.out.println("Picture to the Restoration");
    }
}
