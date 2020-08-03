import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Slogans extends Thread {
    // file and array list for storing file
    private ArrayList<String> fileList = new ArrayList<>();
    File file;

    // overloaded constructor for passing in file
    public Slogans(File inputFile) {
        this.file = inputFile;
    }

    public void run() {
        try {
            // create scanner instance for scanning file
            Scanner scnr = new Scanner(file);
            String line = " ";
            // store each line from file in array list
            while (scnr.hasNextLine()) {
                line = scnr.nextLine();
                fileList.add(line);
            }
            // variables for displaying random line
            int changeQuote = 7000;
            String randomLine = " ";

            // display random line from file
            for (int i = 0; i < fileList.size(); i++) {
                randomLine = fileList.get(ThreadLocalRandom.current().nextInt(fileList.size()));
                System.out.println(randomLine);
                Thread.sleep(changeQuote);
            }
            scnr.close();
            } catch(Exception e) {
                System.out.println("No such file exists..");
            }
    }
}

