package sorts;

import java.util.Arrays;
public class QuickSort {
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    private static int pivot(int[] array, int pivotIndex, int endIndex) {

        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        return swapIndex;
    }
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }
    public static void main(String[] args) {
        int[] myArray = {10, 7, 8, 9, 1, 5};
        int n = myArray.length;
        quickSort(myArray, 0, n - 1);
        System.out.println(Arrays.toString(myArray));
    }
}
