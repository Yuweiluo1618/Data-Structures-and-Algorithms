package DataStructure.Sort;

import java.util.Arrays;

public class Merge_sorting {
    public static void main(String[] args) {
        int[] test = {9, -3, 5, -2, 10 ,0, 20};
        int[] temp = new int[test.length];
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge_sort(test, 0, test.length - 1, temp);
        System.out.println(Arrays.toString(test));

    }
}

class MergeSort {
    public void merge_sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            merge_sort(arr, left, mid, temp);
            merge_sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

    }

    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int leftIndex = left;
        int rightIndex = mid + 1;
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <= right) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex] = arr[leftIndex];
                tempIndex++;
                leftIndex++;
            } else {
                temp[tempIndex] = arr[rightIndex];
                tempIndex++;
                rightIndex++;
            }

        }

        while (leftIndex <= mid) {
            temp[tempIndex] = arr[leftIndex];
            tempIndex++;
            leftIndex++;
        }

        while (rightIndex <= right) {
            temp[tempIndex] = arr[rightIndex];
            tempIndex++;
            rightIndex++;
        }

        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempIndex++;
            tempLeft++;
        }
    }
}

