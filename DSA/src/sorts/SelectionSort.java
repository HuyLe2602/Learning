package sorts;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }


            // Đổi chỗ phần tử nhỏ nhất với phần tử đầu tiên của phần chưa sắp xếp
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    static void main() {
        int[] myArray = {64, 25, 12, 22, 11};
        selectionSort(myArray);
        System.out.print(Arrays.toString(myArray));

    }
}
