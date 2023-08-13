package abstractFactory;

public class SculptureExhibitionService implements ExhibitionService{
    @Override
    public void toExhibition() {
        System.out.println("Sculpture to the Exhibition");
    }
}
