package DataStructure.Search;

import java.util.ArrayList;

public class Binary_Search_All_Value {
    public static void main(String[] args) {
        BinarySearchAV binarySearchAV = new BinarySearchAV();
        int[] test = {1, 2, 3, 10, 10, 10, 10, 12};
        ArrayList<Integer> res = binarySearchAV.binary_search_all_value(test, 0, test.length - 1, 10);
        System.out.println(res);
    }
}

class BinarySearchAV {
    public ArrayList<Integer> binary_search_all_value(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<Integer>();
        }

        int midIndex = (left + right) / 2;
        int midValue = arr[midIndex];


        if (midValue == value) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            int leftIndex = midIndex - 1;

            while (true) {
                if (leftIndex < 0 || arr[leftIndex] != value) {
                    break;
                }
                res.add(leftIndex);
                leftIndex--;
            }

            res.add(midIndex);

            int rightIndex = midIndex + 1;
            while (true) {
                if (rightIndex >= arr.length || arr[rightIndex] != value) {
                    break;
                }
                res.add(rightIndex);
                rightIndex++;
            }
            return  res;

        } else if (midValue > value) {
            return binary_search_all_value(arr, left, midIndex - 1, value);
        } else {
            return binary_search_all_value(arr, left, midIndex + 1, value);
        }
    }

}
