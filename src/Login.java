import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Welcome");

        GridPane grid = (GridPane)FXMLLoader.load(getClass().getResource("sample.fxml"));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        GridPane grid2 = (GridPane)FXMLLoader.load(getClass().getResource("sample2.fxml"));
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(20);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));


        final Text actionTarget = new Text();
        actionTarget.setId("actiontarget");
        grid.add(actionTarget, 1, 2);


        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(Login.class.getResource("Login.css").toExternalForm());

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
