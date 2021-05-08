import java.util.ArrayList;
import java.util.Arrays;

public class PuzzleJavaTesting {
    public static void main(String[] args) {
        PuzzleJava test = new PuzzleJava();

        // 1. Print the sum and return array of values greater than 10
        int [] sampleNumberArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> numsGreaterThanTen = test.printSumAndGreaterThanTen(sampleNumberArray);
        System.out.println(numsGreaterThanTen);

        // 2. Shuffle the array and print name of each person
        ArrayList<String> names = new ArrayList<String>();
        names.add("Nancy");
        names.add("Jinichi");
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");

        ArrayList<String> namesLongerThanFive = test.shuffleAndPrintNames(names);
        System.out.println(namesLongerThanFive);

        // 3. Shuffle the array and display last letter, first letter and message if first letter is a vowel
        ArrayList<Character> letters = new ArrayList<Character>();
        letters.add('a');
        letters.add('b');
        letters.add('c');
        letters.add('d');
        letters.add('e');
        letters.add('f');
        letters.add('g');
        letters.add('h');
        letters.add('i');
        letters.add('j');
        letters.add('k');
        letters.add('l');
        letters.add('m');
        letters.add('n');
        letters.add('o');
        letters.add('p');
        letters.add('q');
        letters.add('r');
        letters.add('s');
        letters.add('t');
        letters.add('u');
        letters.add('v');
        letters.add('w');
        letters.add('x');
        letters.add('y');
        letters.add('z');
        test.suffleAndDisplayLetters(letters);

        // 4. Random numbers between 55-100
        ArrayList<Integer> randomArray = test.generateRandomAndReturnArray();
        System.out.println(randomArray);

        // 5. Random numbers, sort, minimum value and maximum value
        ArrayList<Integer> nextRandomArray = test.randomSortMinMax();
        System.out.println(nextRandomArray);

        // 6. Random string that is 5 characters long
        String str = test.randomStringFiveCharLong();
        System.out.println(str);

        // 7. Array of random string that are 5 characters long
        String[] strArr = test.arrayStringFiveCharLong();
        System.out.println(Arrays.toString(strArr));
    }
}