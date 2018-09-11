package lesson2.homework;

public class QuickSort {

    private QuickSort() {

    }

    public static void sort(Integer[] integers, int left, int right) {
        if (left >= right || integers.length <= 1) {
            return;
        }
        int middle = left + (right - left) / 2;
        Integer comp = integers[middle];
        int i = left;
        int j = right;
        while (i <= j) {
            while (integers[i] < comp) {
                i++;
            }
            while (integers[j] > comp) {
                j--;
            }
            if (i <= j) {
                swap(integers, i, j);
                i++;
                j--;
            }
        }
        if (left < j) {
            sort(integers, left, j);
        }
        if (i < right) {
            sort(integers, i, right);
        }
    }

    private static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
