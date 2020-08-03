import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import java.io.File;
import java.io.IOException;

public class Controller2 implements EventHandler {
    @FXML private Text characterOne;
    @FXML private Text characterTwo;
    @FXML private Button printReport;
    @FXML private TextArea userTextInput;
    Yoda yoda = new Yoda();
    ObiWan obiWan = new ObiWan();

    @FXML
    public void openOnSubmit(ActionEvent newEvent) throws IOException {
        Parent newView = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample2.fxml"));
    }

    public void handleCharacterSelection() {

    }

    public void characterOneButton() {

    }

    public void characterTwoButton() {

    }

    public void addDataToFile() {
        // Declare new objects for File and FileProcessing class
        File file = new File("/Users/jaycruz/Downloads/readandsort.txt");
        FileProcessing newFile = new FileProcessing();
        // Process file, sort and print to new file
        newFile.processFile(file);
        newFile.sortAndPrintToNewFile(file);
    }


    @Override
    public void handle(Event event) {
    }
}