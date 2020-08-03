import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessingTest {

    public static void main(String[] args) throws FileNotFoundException {
        // Declare new objects for File and FileProcessing class
        File file = new File("/Users/jaycruz/Downloads/readandsort.txt");
        FileProcessing newFile = new FileProcessing();
        // Process file, sort and print to new file
        newFile.processFile(file);
        newFile.sortAndPrintToNewFile(file);
    }
}
