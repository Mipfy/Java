import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Menu");
            System.out.println("Choose task:");
            System.out.println("1 - first task" + "\n" + "2 - second task" + "\n" + "3 - third task" + "\n" + "4 - fouth task" + "\n" + "5 - fifth task" + "\n" + "6 - sixth task" + "\n" + "7 - Quit");
            byte function = scan.nextByte();
            switch (function) {
                case 1:
                    first();
                    break;
                case 2:
                    second();
                    break;
                case 3:
                    third();
                    break;
                case 4:
                    fouth();
                    break;
                case 5:
                    fifth();
                    break;
                case 6:
                    sixth();
                    break;
                case 7:
                    break;
            }
            if (function > 7) {
                System.out.println("Ви ввели невірні дані!");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Тільки цифри!!!");

        }
    }

    public static void first() {
        Scanner scan = new Scanner(System.in);
        try {
            double x;
            double y;

            System.out.println("enter x: ");
            x = scan.nextByte();
            System.out.println("enter y: ");
            y = scan.nextByte();
            if (x > 0 && y > 0) {
                System.out.println("Перша чверть");
            } else if (x < 0 && y > 0) {
                System.out.println("Друга чверть");
            } else if (x < 0 && y < 0) {
                System.out.println("Третя чверть");
            } else if (x > 0 && y < 0) {
                System.out.println("Четверта чверть");
            } else if (x == 0 && y < 0) {
                System.out.println("число знаходиться га координатній осі Y+");
            } else if (x == 0 && y > 0) {
                System.out.println("число знаходиться га координатній осі Y-");
            } else if (x < 0 && y == 0) {
                System.out.println("число знаходиться га координатній осі X+");
            } else if (x > 0 && y == 0) {
                System.out.println("число знаходиться га координатній осі X-");
            } else if (x == 0 && y == 0) {
                System.out.println("початок осі координат");
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Тільки цифри!");
        }
    }

    public static void second() {
        Scanner scan = new Scanner(System.in);
        System.out.print("введіть n: ");
        while (!scan.hasNextInt()) {
            System.out.println("Input is not a number");
            System.out.print("Input array size n: ");
            scan.nextLine();
        }
        int n = scan.nextInt();

        int minVal = -50;
        int maxVal = 50;

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(minVal, maxVal);
        }

        System.out.println(Arrays.toString(arr));

        int length = arr.length;
        int counter = 0;

        for (int i = 1; i < length; i++)
            if ((arr[i] < 0 && arr[i - 1] >= 0) || (arr[i] >= 0 && arr[i - 1] < 0)) {
                System.out.println("Index " + i + " changed");
                counter++;
            }
        System.out.println("Changed " + counter + " times");
    }

    public static void third() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Input n: ");
        while (!scan.hasNextInt()) {
            System.out.println("Input is not a number");
            System.out.print("Input array size n: ");
            scan.nextLine();
        }
        int n = scan.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < matrix.length; i++, System.out.println()) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        int maxElement = Integer.MIN_VALUE;
        int maxI = Integer.MIN_VALUE;
        int maxJ = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] >= maxElement && i + j >= maxI + maxJ) {
                    maxElement = matrix[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println("Максимальне значення матриці[" + maxI + "][" + maxJ + "] = " + maxElement);

        int minElement = 100;
        int minI = 100;
        int minJ = 100;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if ((matrix[i][j] <= minElement) && (i + j) <= (minI + minJ)) {
                    minElement = matrix[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }
        System.out.println("мінімальне значеняя матриці[" + minI + "][" + minJ + "] = " + minElement);
    }

    public static void fouth() {
        Scanner scan = new Scanner(System.in);
        System.out.print("введіть n: ");
        while (!scan.hasNextInt()) {
            System.out.println("Input is not a number");
            System.out.print("Input array size n: ");
            scan.nextLine();
        }
        int n = scan.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Матриця: ");
        for (int i = 0; i < matrix.length; i++, System.out.println()) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    public static void fifth(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть слова: ");
        String s = scan.next();
        isPalindrome(s);
    }
    public static String reverseString(String s){
        String r = "";
        for (int i = s.length() - 1; i >= 0; --i)
            r += s.charAt(i);
        return r;


    }
    public static Boolean isPalindrome(String s) {
        if(s.equals(reverseString(s))){
            System.out.println("поліндром");
        }else{
            System.out.println("не поліндром");
        }
        return s.equals(reverseString(s));

    }
    public static void sixth(){
        String row1 = "Year is 2009";
        String row2 = "YNot2Bad";
        String row3 = "1 is a number";
        String row4 = "No digits here";
        String row5 = "3.5423";
        int intValue;


        String[] words = row1.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        System.out.println("Масив слів: ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i] + " ");
        }

        int yes = 0;
        System.out.println("Результат: ");
        for (int i = 0; i < words.length; i++) {
            try {
                intValue = Integer.parseInt(words[i]);
                System.out.println(words[i] + " - Integer");
                yes += 1;
            } catch (NumberFormatException e) {
                System.out.println(words[i] + " - Input String cannot be parsed to Integer.");
            }

        }
        if (yes > 0) {
            System.out.println("Row '" + row1 + "' has integers");
        }
        else {
            System.out.println("This row '" + row1 + "' does not contain any integers");
        }
    }
}