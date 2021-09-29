package DataStructure.Sort;

import java.util.Arrays;

public class Insert_Sorting {


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] test = {-5,1,-3,6,-2,10};
        insertSort.insert_sort(test);
        System.out.println(Arrays.toString(test));
    }

}

class InsertSort{
    public void insert_sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int insertVal = arr[i];
            int insertIndex = i-1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex+1] = insertVal;
        }
    }
}
