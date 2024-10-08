import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.application.Platform;
import javafx.geometry.Pos;
import java.util.Random;

public class DessertGame extends Application {

    //step 7
    private int gameScore = 0;

    @Override
    public void start(final Stage stage) {

        //step 2
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 640, 480);
        stage.setTitle("DessertGame");

        //step 3
        Label score = new Label("Score: 0");
        borderPane.setTop(score);
        BorderPane.setAlignment(score, Pos.TOP_LEFT);

        //step 4
        Button exit = new Button("Exit");
        exit.setOnAction(event -> {Platform.exit();});
        borderPane.setBottom(exit);
        BorderPane.setAlignment(exit, Pos.BOTTOM_RIGHT);

        //step 5
        Pane pane = new Pane();
        borderPane.setCenter(pane);
        BorderPane.setAlignment(pane, Pos.CENTER);

        Random randGen = new Random();
        final Button[] button1 = new Button[8];
        for(int i =0; i<button1.length; i++) {
            Button button2 = new Button();
            if(i ==0){
                button2.setText("Dessert");
            }else {
                button2.setText("Desert");
            }
            button2.setOnAction(event -> {
                if(button2.getText().equals("Dessert")) {
                    this.gameScore++;
                }
                else if(button2.getText().equals("Desert")) {
                    this.gameScore--;
                }
                score.setText("Score:" + this.gameScore);
                scrambleButtons(randGen, button1);

                //step 8
                exit.requestFocus();
            });
            button1[i] = button2;
        }
        scrambleButtons(randGen, button1);
        pane.getChildren().addAll(button1);
        stage.setScene(scene);
        stage.show();
    }

    //step 6
    private void scrambleButtons(Random random, Button[] b)
    {

        for(int i = 0; i < b.length; i++)
        {
            b[i].setLayoutX(random.nextInt(600));
            b[i].setLayoutY(random.nextInt(400));
        }
    }

    public static void main(String[] args) {
        Application.launch();
    }
}