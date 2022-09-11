package sort;

import java.util.Comparator;

public class QuickSort {

    public static <E> void sort(E[] array, Comparator<E> comparator) {
        quickSort(array, comparator, 0, array.length - 1);
    }


    private static <E> void quickSort(E[] array, Comparator<E> comparator, int start,
                                      int end) {
        if (start >= end)
            return;

        int left = start;
        int right = end - 1;
        E pivot = array[end];

        while (left <= right) {
            while (left <= right && comparator.compare(array[left], pivot) < 0)
                left++;

            while (left <= right && comparator.compare(array[right], pivot) > 0)
                right--;
            if (left <= right) {

                swap(array, left, right);

                left++;
                right--;
            }
        }

        swap(array, left, end);


        quickSort(array, comparator, start, left - 1);
        quickSort(array, comparator, left + 1, end);
    }

    private static <E> void swap(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}