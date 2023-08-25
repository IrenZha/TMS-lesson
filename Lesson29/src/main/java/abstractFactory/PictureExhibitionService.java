package abstractFactory;

public class PictureExhibitionService implements ExhibitionService{
    @Override
    public void toExhibition() {
        System.out.println("Picture to the Exhibition");
    }
}
