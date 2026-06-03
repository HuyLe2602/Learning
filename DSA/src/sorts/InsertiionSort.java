package sorts;

import java.util.Arrays;

public class InsertiionSort {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= -1 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }

        }
    }
    public static void main(String[] args) {
        int[] myArray = {5, 2, 9, 1, 5, 6};
        insertionSort(myArray);
        System.out.println(Arrays.toString(myArray));
    }



}
