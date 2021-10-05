package DataStructure.Sort;

import java.util.Arrays;

public class Heap_Sorting {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] test = {4, 6, 8, 5, 9};
        heapSort.heap_sort(test);
        System.out.println(Arrays.toString(test));
    }

}

class HeapSort {
    public void heap_sort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            generateHeap(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            generateHeap(arr, 0, i);
        }

    }

    public void generateHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }
}
