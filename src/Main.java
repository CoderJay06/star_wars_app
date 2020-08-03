import java.io.File;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) throws SQLException {
        // DATABASE TEST
//        HighScoreDatabase.createNewDB();
//
//        // test inserting data into records
//        HighScoreDatabase.addData("Batman33", 100);
//        HighScoreDatabase.addData("JohnWayne44", 150);
//
//        // test selecting data from records
//        HighScoreDatabase.retrieveData("Batman33");
//        HighScoreDatabase.displayAllRecords();
//        HighScoreDatabase.clearAllRecords();

        // DATASTRUCTURES TEST
        Timestamp time = new Timestamp(System.currentTimeMillis());

        DataStructures data = new DataStructures();

        data.getUserInput("Hello world");
        System.out.println();
        data.displayStackWithHashObj();
        data.displayUserInput();

        // FILE PROCESSING TEST
        // Declare new objects for File and FileProcessing class
        File file = new File("/Users/jaycruz/Downloads/readandsort.txt");
        FileProcessing newFile = new FileProcessing();
        // Process file, sort and print to new file
        newFile.processFile(file);
        newFile.sortAndPrintToNewFile(file);

        // GENERICS TEST
        Yoda yoda = new Yoda();
        ObiWan obiWan = new ObiWan();
        Mickey mickey = new Mickey();

        GenericsStarWars gsw = new GenericsStarWars();

        //call your method here with the above objects
        System.out.println(gsw.getOnlyStarWarsCharacter(obiWan));

        // THREADS TEST
        File quotesFile = new File("/Users/jaycruz/Downloads/quotes.txt");
        Slogans sloganReader = new Slogans(quotesFile);

        Thread threadReader = new Thread(sloganReader);

        threadReader.run();
    }
}
