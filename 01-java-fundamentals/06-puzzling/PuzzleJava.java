import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
    
    // 1. Print the sum and return array of values greater than 10
    public ArrayList<Integer> printSumAndGreaterThanTen(int[] arr) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int sum = 0;
        for (int val: arr) {
            sum += val;
            if (val > 10) {
                numList.add(val);
            }
        }
        System.out.println(sum);
        return numList;
    }

    // 2. Shuffle the array and print name of each person
    public ArrayList<String> shuffleAndPrintNames(ArrayList<String> arr) {
        ArrayList<String> nameList = new ArrayList<String>();
        
        Collections.shuffle(arr);
        
        for (String name : arr) {
            System.out.println(name);
            if (name.length() > 5) {
                nameList.add(name);
            }
        }
        return nameList;
    }
    // 3. Shuffle the array and display last letter, first letter and message if first letter is a vowel
    public void suffleAndDisplayLetters(ArrayList<Character> arr) {
        ArrayList<Character> vowels = new ArrayList<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        Collections.shuffle(arr);

        System.out.println("Last letter: " + arr.get(arr.size()-1));
        System.out.println("First letter: " + arr.get(0));
        if (vowels.contains(arr.get(0))) {
            System.out.println("The first letter is a vowel!");
        }
    }

    // 4. Random numbers between 55-100
    public ArrayList<Integer> generateRandomAndReturnArray() {
        Random r = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        
        for (int i = 1; i <= 10; i++) {
            int num = r.nextInt(46) + 55;
            randomNumbers.add(num);
        }
        return randomNumbers;
    }

    // 5. Random numbers, sort, minimum value and maximum value
    public ArrayList<Integer> randomSortMinMax() {
        Random r = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            int num = r.nextInt(46) + 55;
            randomNumbers.add(num);
        }
        Collections.sort(randomNumbers);
        System.out.println("The minimum value is: " + randomNumbers.get(0));
        System.out.println("The minimum value is: " + randomNumbers.get(randomNumbers.size() - 1));
        return randomNumbers;
    }

    // 6. Random string that is 5 characters long
    public String randomStringFiveCharLong() {
        Random r = new Random();
        String str;

        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
                        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        char[] randomLetters = new char[5];
        
        for (int i = 0; i <= 4; i++) {
            int rand = r.nextInt(26);
            randomLetters[i] = letters[rand]; 
        }
        str = new String(randomLetters);
        return str;
    }

    // 7. Array of random string that are 5 characters long
    public String[] arrayStringFiveCharLong() {
        String[] randomStrings = new String[10];
        
        for (int i = 0; i <= 9; i++) {
            String str = randomStringFiveCharLong();
            randomStrings[i] = str; 
        }
        return randomStrings;
    }
}