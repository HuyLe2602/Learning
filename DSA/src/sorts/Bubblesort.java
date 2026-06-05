package sorts;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Bubblesort {
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Đổi chỗ hai phần tử
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static void main(String[] args) {
        int[] myArray = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }
}