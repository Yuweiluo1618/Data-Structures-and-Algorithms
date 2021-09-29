package DataStructure.Sort;

import java.util.Arrays;

public class Shell_Sorting_Swap {
    public static void main(String[] args) {
        int[] test = {3,-1,6,-3,4};
        ShellSortSwap shellSortSwap = new ShellSortSwap();
        shellSortSwap.shell_sort_swap(test);

    }
}

class ShellSortSwap{
    public void shell_sort_swap(int[] arr){
        int temp;
        //
        for(int i = arr.length/2; i > 0; i /= 2){
            for(int j = i; j < arr.length; j++){
                for (int k = j-i; k >= 0; k -= i){
                    if (arr[k] > arr[k+i]){
                       temp = arr[k+i];
                       arr[k+i] = arr[k];
                       arr[k] = temp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
