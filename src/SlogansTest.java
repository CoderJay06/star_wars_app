import java.io.File;

public class SlogansTest {

    public static void main(String[] args) {
        File quotesFile = new File("/Users/jaycruz/Downloads/quotes.txt");
        Slogans sloganReader = new Slogans(quotesFile);

        Thread threadReader = new Thread(sloganReader);

        threadReader.run();
    }
}
