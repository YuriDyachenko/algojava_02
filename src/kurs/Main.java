package kurs;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //там генерируется начальный массив, который будет потом использоваться в разных заданиях
        ArraysMethods am = new ArraysMethods();
        //объект для фиксации и вывода прошедшего времени
        Duration duration = new Duration();
        //задание 2.1
        basicClassOperations(am, duration);
        //задание 2.2
        searchMethods(am, duration);
        //задание 2.3
        sort(am, duration);
        //задание 2.4
        bubbleSort(am, duration);
        //задание 2.5
        selectionSort(am, duration);
        //задание 2.6
        byInsertionSort(am, duration);
    }

    private static void byInsertionSort(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 2.6 - - - - -");
        String[] arr = am.getCopyOfBaseArray();
        duration.fix();
        am.byInsertionSort(arr);
        duration.outAndFix(" сортировка методом вставки");
    }

    private static void selectionSort(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 2.5 - - - - -");
        String[] arr = am.getCopyOfBaseArray();
        duration.fix();
        am.selectionSort(arr);
        duration.outAndFix(" сортировка методом выбора");
    }

    private static void bubbleSort(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 2.4 - - - - -");
        String[] arr = am.getCopyOfBaseArray();
        duration.fix();
        am.bubbleSort(arr);
        duration.outAndFix(" пузырьковая сортировка");
    }

    private static void sort(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 2.3 - - - - -");
        String[] arr = am.getCopyOfBaseArray();
        duration.fix();
        am.sort(arr);
        duration.outAndFix(" быстрая сортировка");
    }

    private static void searchMethods(ArraysMethods am, Duration duration) {
        System.out.println("- - - - - Задание 2.2 - - - - -");
        duration.fix();
        duration.outAndFix(" линейный поиск, индекс = " + am.linearSearch());
        duration.outAndFix(" двоичный поиск, индекс = " + am.binarySearch());
    }

    private static void basicClassOperations(ArraysMethods am, Duration duration) {
        Random random = am.getRandom();
        System.out.println("- - - - - Задание 2.1 - - - - -");
        System.out.println(" на примере массива из 400 строковых значений от 5 до 10 символов");
        System.out.println("  базовые методы Arrays и их продолжительность");
        duration.fix();
        String[] arr = am.getCopyOfBaseArray();
        duration.outAndFix("   arr = Arrays.copyOf())");
        String[] copyArr = Arrays.copyOfRange(arr, 0, arr.length);
        duration.outAndFix("   copyArr = Arrays.copyOfRange())");
        duration.outAndFix("   Arrays.equals(arr, copyArr) = " + Arrays.equals(arr, copyArr));
        Arrays.sort(arr);
        duration.outAndFix("   Arrays.sort(arr)");
        Arrays.fill(copyArr, "new value");
        duration.outAndFix("   Arrays.fill(copyArr...");
        String arrToString = Arrays.toString(arr);
        duration.outAndFix("   Arrays.toString(arr)");
        for (int i = 0; i < 200; i++) {
            String temp = arr[random.nextInt(arr.length)];
        }
        duration.outAndFix("  200 случайных обращений к массиву");
    }
}
