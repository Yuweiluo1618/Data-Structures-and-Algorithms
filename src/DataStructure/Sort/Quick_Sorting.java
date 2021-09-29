package DataStructure.Sort;

import java.util.Arrays;

public class Quick_Sorting {
    public static void main(String[] args) {
        int[] test = {5,5,5,5,5,5};
        QuickSort quickSort = new QuickSort();
        quickSort.quick_sort(test, 0, test.length-1);
        System.out.println(Arrays.toString(test));
    }
}

class QuickSort{
    public void quick_sort(int[] arr, int left, int right){
        int l = left;
        int r =  right;
        int pivot = arr[(left+right)/2];
        int temp = 0;

        while (l < r){

            while (arr[l] < pivot){
                l += 1;
            }

            while (arr[r] > pivot){
                r -= 1;
            }

            if(l >= r){
                break;
            }

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if(arr[r] == pivot){
                l++;
            }
            if(arr[l] == pivot){
                r--;

            }
        }

        if(l == r){
            l++;
            r--;
        }

        if(left < r){
            quick_sort(arr, left, r);
        }

        if(right > l){
            quick_sort(arr, l, right);
        }
    }
}
