package DataStructure.Search;

public class Binary_Search {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] test = {-1, 4, 6, 8};
        int index = binarySearch.binary_search(test, 0, test.length - 1, 6);
        System.out.println(index);
    }
}

class BinarySearch {
    public int binary_search(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (value == arr[mid]) {
            return mid;
        } else if (value > arr[mid]) {
            return binary_search(arr, mid + 1, right, value);
        } else {
            return binary_search(arr, left, mid - 1, value);
        }
    }
}
