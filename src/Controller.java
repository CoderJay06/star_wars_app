import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private javafx.scene.control.Button closeButton;
    @FXML private TextField userData;
    Yoda yoda = new Yoda();
    ObiWan obiWan = new ObiWan();
    Mickey mickey = new Mickey();
    GenericsStarWars gsw = new GenericsStarWars();

    public Controller() {

    }

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void closeOnSubmit(ActionEvent newEvent) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        closeButton.setText("User signing in..");
        Scene newScene = new Scene(newView);
        Stage stage = (Stage) closeButton.getScene().getWindow();
        Stage newWindow = new Stage();
        newWindow.setScene(newScene);
        stage.close();
        newWindow.show();
    }

    public void characterChoiceOne() {
        System.out.print("You've selected: ");
        System.out.println(gsw.getOnlyStarWarsCharacter(yoda));
    }

    public void characterChoiceTwo() {

        System.out.print("You've selected: ");
        System.out.println(gsw.getOnlyStarWarsCharacter(obiWan));
    }

    public void characterChoiceThree() {
        System.out.print("You've selected: ");
        System.out.println(gsw.getOnlyStarWarsCharacter(mickey));
    }

    public void processUserData() throws SQLException {
        // insert entered username into highscore db
        String username = userData.getText();
        // Process user data into database
        HighScoreDatabase.createNewDB();

        // test inserting data into records
        HighScoreDatabase.addData(username, 0);
    }

//    public void handleSubmitButtonAction(ActionEvent submitEvent) {
//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();
//    }
}
