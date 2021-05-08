public class BasicJavaTesting {
    public static void main(String[] args) {
        BasicJava test = new BasicJava();
        
        // test.printNumbers(255);
        
        // test.printOddNumbers(255);
        
        // test.printSum(255);
        
        // int[] myArray = {1, 3, 5, 7, 9, 13};
        // test.iterateArray(myArray);

        // int [] maxArray = {-3, -5, -7};
        // test.findMax(maxArray);

        // int [] aveArray = {2, 10, 3};
        // test.getAverage(aveArray);

        // test.arrayOdd(255);

        // int [] greaterThanYArray = {1, 3, 5, 7};
        // int count = test.greaterThanY(greaterThanYArray, 3);
        // System.out.println(count);

        // int [] squareArray = {1, 5, 10, -2};
        // test.squareValue(squareArray);

        // int[] negativeArray = {1, 5, 10, -2};
        // test.eliminateNegatives(negativeArray);

        // int [] sampleArray = {1, 5, 10, -2};
        // test.getMaxMinAve(sampleArray);

        int [] shiftArray = {1, 5, 10, 7, -2};
        test.shiftValue(shiftArray);
    }
}