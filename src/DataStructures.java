import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Stack;

public class DataStructures {

    // declare data structure objects for storing input
    HashMap userHash = new HashMap();
    Stack userStack = new Stack();

    // class constructor
    public DataStructures() {

    }

    // define method for receiving user input
    public void getUserInput(String choice) {
        userHash.put(getAndFormatCurrentTime(), choice);
        addToStack(userHash);
    }

    // define method for getting and formatting current time
    public String getAndFormatCurrentTime() {
        // declare current time for hashmap key
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        Date date = new Date();
        date.setTime(currentTime.getTime());
        DateFormat formatDateAnTime = new SimpleDateFormat("hh:mma");
        return formatDateAnTime.format(currentTime);
    }

    // define method for displaying user input
    public void displayUserInput() {
        String result = " ";
        for (Object key : userHash.keySet()) {
            result = key.toString() + ", ";
        }

        for (Object value : userHash.values()) {
           result += value.toString();
        }

        System.out.println(result);
    }

    // define method for displaying stack with hash objects
    public void displayStackWithHashObj() {
        System.out.println("Stack with hash objects: " + userStack.toString());
    }

    // method for adding hashmap object to stack
    public void addToStack(HashMap userHash) {
        userStack.push(userHash);
    }
}