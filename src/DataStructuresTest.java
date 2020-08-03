import java.sql.Timestamp;

public class DataStructuresTest {
    public static void main(String[] args) {
        Timestamp time = new Timestamp(System.currentTimeMillis());

        DataStructures data = new DataStructures();

        data.getUserInput("Hello world");
        System.out.println();
        data.displayStackWithHashObj();
        data.displayUserInput();
    }
}
