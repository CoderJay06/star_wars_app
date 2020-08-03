import java.sql.SQLException;

public class HighScoreTest {

    public static void main(String[] args) throws SQLException {
        HighScoreDatabase.createNewDB();

        // test inserting data into records
        HighScoreDatabase.addData("Batman33", 100);
        HighScoreDatabase.addData("JohnWayne44", 150);

        // test selecting data from records
        HighScoreDatabase.retrieveData("Batman33");
        HighScoreDatabase.displayAllRecords();
        HighScoreDatabase.clearAllRecords();

    }
}
