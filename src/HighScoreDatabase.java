import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.time.Period;

public class HighScoreDatabase {
    static Connection dbConnect = null;
    static Statement dbStatement = null;
    String userName;
    int score;
    static HighScoreDatabase record;

    public HighScoreDatabase() {

    }

    public HighScoreDatabase(String userName,
                             int score) {
        this.userName = userName;
        this.score = score;
    }

    // method for connecting to a database
    private static void connectToDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnect = DriverManager.getConnection("jdbc:sqlite:highscores.db");
//            dbConnect = DriverManager.getConnection("");
//            dbConnect =  DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            System.out.println("Database has connected successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
    // method for creating new db in the current directory
    public static void createNewDB() {
        try {
            connectToDB();
            dbStatement = dbConnect.createStatement();
            System.out.println("Creating new table..");

            // create records table
            String createDB = "CREATE TABLE IF NOT EXISTS records (" +
                              "username        String NOT NULL, \n" +
                              "score           Integer NOT NULL" +
                              ");";
            dbStatement.execute(createDB);

            dbStatement.close();
            dbConnect.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Database created successfully");
    }

    // method to add to records table
    public static void addData(String userName, int userScore) throws SQLException {
        connectToDB();
        dbConnect.setAutoCommit(false);

        // sql query to insert data into table
        String insertQuery = "INSERT INTO records (username, score) VALUES (?, ?);";

        PreparedStatement pStatement = dbConnect.prepareStatement(insertQuery);
        pStatement.setString(1, userName);
        pStatement.setInt(2, userScore);
        int addRecordResult = pStatement.executeUpdate();
        determineIfRecordAdded(addRecordResult);

        dbConnect.commit();
        dbConnect.close();
        pStatement.close();
    }

    // method for retrieving data from records table
    public static void retrieveData(String userName) throws SQLException {
        connectToDB();
        dbConnect.setAutoCommit(false);

        // sql query to select specific record by username
        String selectQuery = "SELECT * FROM records WHERE username = ?;";
        PreparedStatement pStatement = dbConnect.prepareStatement(selectQuery);
        pStatement.setString(1, userName);
        ResultSet selectResult = pStatement.executeQuery();
        ifRecordExists(selectResult);
        processRecord(selectResult);
        showRecord(record, selectResult);

        selectResult.close();
        pStatement.close();
        dbConnect.close();
    }

    // method for deleting all entries from records table
    public static void clearAllRecords() throws SQLException {
        connectToDB();
        dbStatement = dbConnect.createStatement();

        // sql query to delete all db entries from records
        String clearRecordsQuery = "DELETE FROM records;";
        int clearRecordsResult = dbStatement.executeUpdate(clearRecordsQuery);
        determineIfRecordsCleared(clearRecordsResult);
        dbStatement.close();
        dbConnect.close();
    }

    // method for displaying all data from records
    public static void displayAllRecords() throws SQLException {
        connectToDB();
        dbStatement = dbConnect.createStatement();

        // sql query to select all entries from records
        String selectAllRecordsQuery = "SELECT * FROM records;";
        ResultSet displayResult = dbStatement.executeQuery(selectAllRecordsQuery);
        ifRecordExists(displayResult);
        formatAndPrintRecords(displayResult);
    }

    // helper method for processing select query result
    private static void processRecord(ResultSet result) throws SQLException {
        record = new HighScoreDatabase(
                result.getString("username"),
                result.getInt("score")
        );
    }

    // helper method for determining if record exists
    private static boolean ifRecordExists(ResultSet result) throws SQLException {
        boolean recordExists = false;
        if (result.next()) {
            recordExists = true;
        }
        else {
            System.out.println("Record does not exist..");
        }
        return recordExists;
    }

    // helper method for printing all entries from records
    public static void formatAndPrintRecords(ResultSet result) throws SQLException {
        while (result.next()) {
            System.out.println();
            System.out.println("************************");
            System.out.print("Username: ");
            System.out.println(result.getString("username"));
            System.out.print("Score: ");
            System.out.println(result.getInt("score"));
            System.out.println("*************************");
            System.out.println();
        }
    }

    // helper method to show selected record from records
    private static void showRecord(HighScoreDatabase record, ResultSet result) throws SQLException {
        while (result.next()) {
            System.out.print("User Name: ");
            System.out.println(record.userName);
            System.out.print("Score: ");
            System.out.println(record.score);
        }
    }

    // helper method for determining added record query success
    private static void determineIfRecordAdded(int result) {
        if (result > 0)
            System.out.println("Successfully added record..");
        else
            System.out.println("Could not add record..");
    }

    // helper method to determine if all records cleared successfully
    private static void determineIfRecordsCleared(int result) {
        if (result > 0)
            System.out.println("Successfully cleared all records..");
        else
            System.out.println("Could not clear records..");
    }
}
