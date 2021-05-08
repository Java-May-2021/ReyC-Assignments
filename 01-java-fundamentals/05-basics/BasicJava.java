import java.util.ArrayList;
import java.util.Arrays;

public class BasicJava {
    
    // Print 1-255
    public void printNumbers(int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(i);
        }
    }

    // Print odd numbers between 1-255
    public void printOddNumbers(int num) {
        for (int i = 1; i <= 255; i+=2) {
            System.out.println(i);
        }
    }

    // Print Sum
    public void printSum(int num) {
        int sum = 0;
        for (int i = 0; i <= 255; i++) {
            sum += i;
            String result = String.format("New number: %d Sum: %d", i, sum);
            System.out.println(result);
        }
    }

    // Iterating through an array
    public void iterateArray(int[] arr) {
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // Find Max
    public void findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("The maximum value is: " + max);
    }

    // Get Average
    public void getAverage(int[] arr) {
        int sum = 0;
        double ave;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        ave = sum / arr.length;
        System.out.println("The average value is: " + ave);
    }

    // Array with Odd Numbers
    public void arrayOdd(int num) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        
        for (int i = 1; i <= num; i+=2) {
            numList.add(i);
        }
        System.out.println(numList);
    }

    // Greater Than Y
    public int greaterThanY(int[] arr, int y) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > y) {
                count = count + 1;
            }
        }
        return count;
    }

    // Square the values
    
    // public void squareValue(int[] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         arr[i] = arr[i] * arr[i];
    //     }
    //     System.out.println(Arrays.toString(arr));
    // }

    public void squareValue(int [] arr) {
        for (int num : arr) {
            num *= num;
            System.out.println(num);
        }
    }

    // Eliminate Negative Numbers
    public void eliminateNegatives(int[] arr) {
        for (int num : arr) {
            if (num < 0) {
                num = 0;
            }
            System.out.println(num);
        }
    }

    // Max, Min, and Average
    public void getMaxMinAve(int[] arr) {
        ArrayList<Double> numList = new ArrayList<Double>();
        double ave, sum = 0, max = arr[0], min = arr[0];
        for (int i =1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] < min) {
                min = arr[j];
            }
        }
        for (int num : arr) {
            sum += num;
        }
        ave = sum / arr.length;
        numList.add(max);
        numList.add(min);
        numList.add(ave);
        System.out.println(numList);
    }

    // Shifting the Values in the Array
    public void shiftValue(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = 0;
        System.out.println(Arrays.toString(arr));
    }

}