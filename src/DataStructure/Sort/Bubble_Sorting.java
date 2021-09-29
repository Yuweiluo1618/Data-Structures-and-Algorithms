package DataStructure.Sort;

public class Bubble_Sorting {
    public static void main(String[] args) {
        int[] test = {3,9,-1,10,-2};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble_sort(test);

    }
}

class BubbleSort{
    public void bubble_sort(int[] arr){
        boolean is_swap = false;
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    is_swap = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //如果一次排列没有交换任何两个数说明数已经有序
            if(!is_swap){
                break;
            }
            else {
                is_swap = false;
            }
        }

        for (int item : arr){
            System.out.print(item+ " ");
        }

    }
}
