import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private Image imageBack = new Image("TicTacToeBoardver02.png");
    private FlowPane tictactoe = new FlowPane(Orientation.HORIZONTAL);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding( new Insets(25, 25, 25, 25));
        gridPane.setHgap(2.5);
        gridPane.setVgap(2.5);
        gridPane.setBackground(background);

        ImageView img;
        img = new ImageView.vievCircle();
        tictactoe.getChildren().add(img);

        gridPane.add(tictactoe, 0, 0, 1, 1);

        Scene scene = new Scene(gridPane, 1400, 1400, Color.BLUE);

        primaryStage.setTitle("Tic Tac Toe by Konrad Jamorek");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
