import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int fNA(int[] array) {
        int count = 0;
        int sum = 0;
        for (final int el : array) {
            if(el < 0){
                sum += el;
                count++;
            }
        }
        return sum / count;
    }

    public static boolean hN(int[] array){
        int negativeNumbers = 0;
        for(int el : array) {
            if(el < 0) negativeNumbers++;
        }

        return negativeNumbers != 0;
    }

    public static int[] inputArray(int size){
        Scanner scan = new Scanner(System.in);
        int input;
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            while (true) {
                try {
                    input = scan.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.print("Введіть лише байт числового типу: ");
                    scan.nextLine();
                }
            }
            arr[i] = input;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;
        while (true) {
            try {
                System.out.print("Введіть розмір масиву: ");
                size = scan.nextInt();
                if(size < 0){
                    System.out.println("Розмір має бути додатній!!!! ");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Вхід має бути цілим числом!!!! ");
                scan.nextLine();
            }
        }
        System.out.print("Введіть елементи масиву: ");

        int[] arr = inputArray(size);
        if(!hN(arr)){
            System.out.print("Масив не містить від’ємних чисел!! ");
            System.exit(0);
        }

        System.out.println("Масив: " + Arrays.toString(arr));
        System.out.println("Масив середнньго відʼємних чисел: " + fNA(arr));
    }
}