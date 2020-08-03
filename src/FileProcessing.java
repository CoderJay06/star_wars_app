import java.io.*;
import java.util.*;


public class FileProcessing {
    Scanner scanFile;
    ArrayList<Integer> fileList = new ArrayList<>();

    public void processFile(File file) {
        try {
            // Initiate new scan object for reading file
            scanFile = new Scanner(file);
            // Declare string variable for storing file contents
            String fileContents = " ";
            // Output each line in file while line exists
            System.out.println("Original: ");
            while (scanFile.hasNextLine()) {
                fileContents = scanFile.nextLine();
                System.out.println(fileContents);
            } // Close file
            scanFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sortAndPrintToNewFile(File file) {
        try {
            // Initiate writer object with new file
            PrintWriter writer = new PrintWriter("/Users/jaycruz/Downloads/newsort.txt");
            // Initiate scanner for reading passed in file
            scanFile = new Scanner(file);
            // Add each existing line from file into array list
            while (scanFile.hasNextInt()) {
                fileList.add(scanFile.nextInt());
            }
            // Sort file contents using Collections
            Collections.sort(fileList);
            // Output array list displaying sorted file contents
            System.out.println("Sorted: ");
            System.out.println(fileList);
            // Write file contents to new file
            for (int i = 0; i < fileList.size(); i++)
                writer.write(fileList.get(i).toString() + " ");
            // Close new file
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
