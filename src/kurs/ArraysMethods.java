package kurs;

import java.util.Arrays;
import java.util.Random;

public class ArraysMethods {
    private final int size = 400;
    private final String[] baseArray;
    private final String[] sortedArray;
    private final Random random;
    private final String randomValue;

    public ArraysMethods() {
        random = new Random();
        baseArray = new String[size];
        fillBaseArray();
        randomValue = baseArray[random.nextInt(size)];
        sortedArray = getCopyOfBaseArray();
        Arrays.sort(sortedArray);
    }

    public Random getRandom() {
        return random;
    }

    public String[] getCopyOfBaseArray() {
        return Arrays.copyOf(baseArray, size);
    }

    private void fillBaseArray() {
        String consonants = "qwrtpsdfghklzxcvbnmjy";
        String vowels = "euioa";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < baseArray.length; i++) {
            int length = random.nextInt(6) + 5;
            for (int j = 0; j < length; j++) {
                stringBuilder.append(getRandomChar(j % 2 == 0 ? consonants : vowels));
            }
            baseArray[i] = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    private char getRandomChar(String s) {
        return s.charAt(random.nextInt(s.length()));
    }

    public int linearSearch() {
        for (int i = 0; i < size; i++) {
            if (randomValue.equals(sortedArray[i])) return i;
        }
        return -1;
    }

    public int binarySearch() {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int res = sortedArray[middle].compareTo(randomValue);
            if (res < 0) low = middle + 1;
            else if (res > 0) high = middle - 1;
                else return middle;
        }
        return -1;
    }

    public void sort(String[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(String[] arr, int low, int high) {
        if (low >= high) return;
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        String opora = arr[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i].compareTo(opora) < 0) i++;
            while (arr[j].compareTo(opora) > 0) j--;
            //меняем местами
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void bubbleSort(String[] arr) {
        for (int i = arr.length - 1; i >= 1; i--)
            for (int j = 0; j < i; j++)
                if (arr[j].compareTo(arr[j + 1]) > 0) swap(arr, j, j + 1);
    }

    public void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0)
                    min = j;
            }
            swap(arr, i, min);
        }
    }

    public void byInsertionSort(String[] arr) {
        int in;
        for (int i = 1; i < arr.length; i++) {
            String buff = arr[i];
            in = i;
            while (in > 0 && arr[in - 1].compareTo(buff) >= 0) {
                arr[in] = arr[in - 1];
                --in;
            }
            arr[in] = buff;
        }
    }

}
