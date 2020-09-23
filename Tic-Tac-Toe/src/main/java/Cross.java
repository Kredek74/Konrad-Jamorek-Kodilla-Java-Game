import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Cross {

    private Image cross = new Image("file:src/resources/Cross.png");

    public ImageView viewCross() {
        return new ImageView(cross);
    }
}
