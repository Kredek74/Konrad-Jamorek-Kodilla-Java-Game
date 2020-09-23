import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TicTacToeKonrad extends Application {

    private Button [][] gameBoard;
    private Button buttonNewGame;
    private Label textCounter;
    private Label textX;
    private Label textY;
    private final int column = 3;
    private final int row = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10));

        GridPane gridPane = new GridPane();

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
                button.setOnAction(event->{
                    button.setText("X");
                    setComputerMove(gridPane);
                });
            }
        }

        textCounter = new Label("Wygrane:");
        textCounter.setFont(new Font(20));
        gridPane.add(textCounter, 0,9);

        textX = new Label("X -> 0");
        textX.setFont(new Font(20));
        gridPane.add(textX, 0,10);

        textY = new Label("O -> 0");
        textY.setFont(new Font(20));
        gridPane.add(textY, 0,11);

        buttonNewGame = new Button("Nowa \n  Gra");
        buttonNewGame.setFont(new Font(20));
        gridPane.add(buttonNewGame, 1,10);
        buttonNewGame.setId("button-new-game");
        buttonNewGame.setAlignment(Pos.BOTTOM_CENTER);

        buttonNewGame.setOnAction(action -> {
            for (int columne = 0; columne<3; columne++){
                for(int row =0; row<3; row++){
                    gameBoard[column][row].setText("");
                    gameBoard[column][row].setDisable(false);
                }
            }
        });

        Scene scene = new Scene(gridPane, 700, 700, Color.BLACK);

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
        buttons.get(randomNumber).setText("O");
    }
}
