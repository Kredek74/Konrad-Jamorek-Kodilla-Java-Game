import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TicTacToeKonrad extends Application {

    private String humanLetter = "O";
    private String computerLetter = "X";
    private final int columnIndex = 3;
    private final int rowIndex = 5;
    private Button startButton;
    private GridPane gridPane = new GridPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(50));

        Button startButton = new Button("Start \n Game");
        gridPane.add(startButton, columnIndex, rowIndex);
        startButton.setId("button-new-game");

        BorderPane.setAlignment(startButton, Pos.BOTTOM_CENTER);
        borderPane.setBottom(startButton);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        gridPane.setPadding(new Insets(50));
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                gridPane.add(button, column, row);
                GridPane.setHgrow(button, Priority.ALWAYS);
                GridPane.setVgrow(button, Priority.ALWAYS);
                gridPane.setHgap(10);
                gridPane.setVgap(10);
                button.setOnAction(event->{
                    button.setText(humanLetter);
                    button.setFont(Font.font("Arial", 72));
                    button.setStyle("-fx-border-color: blue");
                    Text humanText = new Text(humanLetter);
                    humanText.setFill(Color.BLUE);

                    setComputerMove(gridPane);
                });
            }
        }

        Scene scene = new Scene(gridPane, 660, 600, Color.BLACK);

        primaryStage.setTitle("TicTacToe by Konrad Jamorek");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setComputerMove(GridPane gridPane) {

        List<Button> buttons = gridPane.getChildren().stream().filter(node -> node instanceof Button)
                .map(node -> (Button) node)
                .filter(button -> button.getText() == null || button.getText().equals(""))
                .collect(Collectors.toList());

        Random randomButton = new Random();
        int randomNumber = randomButton.nextInt(buttons.size());
        buttons.get(randomNumber).setText(computerLetter);
        buttons.get(randomNumber).setFont(Font.font("Arial", 72));
        buttons.get(randomNumber).setStyle("-fx-border-color: red");
        Text computerText = new Text(computerLetter);
        computerText.setFill(Color.RED);
    }
}
