import java.util.ArrayList;

public class ExceptionSample {
    public void assignIntToInteger() {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (int i = 0; i < myList.size(); i++) {
            // Integer castedValue = (Integer) myList.get(i);
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println("Successfully casted the value " + castedValue);
            } catch (ClassCastException e) {
                System.out.println("The value you're casting is not of the same type.");
            }
        }
    }
}