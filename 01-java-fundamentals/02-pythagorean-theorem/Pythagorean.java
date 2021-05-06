import java.util.Scanner;

public class Pythagorean {
    public double calculateHypotenuse() {

        int legA, legB;
        double squareA, squareB, hypotenuseC;
        
        Scanner legValues = new Scanner(System.in);
        
        // Enter the value of leg A
        System.out.println("Enter the value of leg A: ");
        legA = legValues.nextInt();

        // Enter the value of leg B
        System.out.println("Enter the value of leg B: ");
        legB = legValues.nextInt();

        legValues.close();

        // Get the value of the hypotenuse
        squareA = Math.pow(legA, 2);
        squareB = Math.pow(legB, 2);
        hypotenuseC = Math.sqrt(squareA + squareB);
        return hypotenuseC;
    }
}