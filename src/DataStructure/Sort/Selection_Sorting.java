package DataStructure.Sort;

import java.util.Arrays;

public class Selection_Sorting {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] test = {9,-1,12,-3,5};
        selectSort.select_sort(test);
//        System.out.println(Arrays.toString(test));
    }
}

class SelectSort{
    public void select_sort(int[] arr){
        int temp;;
        int min_index;
        for (int i = 0; i < arr.length-1; i++){
            min_index = i;
            for(int j = i+1; j < arr.length; j++ ){
                if(arr[j] < arr[min_index]){
                    min_index = j;
                }
            }
            //优化如果min不等于每次比较的第一个值在交换
            if(min_index != i) {
                temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
                System.out.println(Arrays.toString(arr));
            }

        }
    }
}