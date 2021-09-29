package DataStructure.Sort;

public class Shell_Sorting_Insert {
    public static void main(String[] args) {
        int[] test = {3,-1,6,-3,4};
        ShellSortSwap shellSortSwap = new ShellSortSwap();
        shellSortSwap.shell_sort_swap(test);
    }
}

class ShellSortInsert{
    public void shell_sort_insert(int[] arr){
        for(int i = arr.length/2; i > 0; i /= 2){
           for(int j = i; j < arr.length; j++){
               int insertVal = arr[j];
               int insertIndex = j - i;
               while (insertIndex >= 0 && arr[insertIndex] > insertVal){
                   arr[insertIndex] = arr[insertIndex+i];
                   insertIndex -= i;
               }
               arr[insertIndex+i] = insertVal;
           }
        }
    }
}
