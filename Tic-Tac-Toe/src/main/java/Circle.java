import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Circle {

    private Image circle = new Image("Circle.png");

    public ImageView viewCircle() {
        return new ImageView(circle());
    }
}
