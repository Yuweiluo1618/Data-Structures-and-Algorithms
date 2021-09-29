package DataStructure.Search;

public class Insert_Search {
    public static void main(String[] args) {
        int[] test = {1,3,4};
//        for (int i = 0; i < 20; i++) {
//            test[i] = i;
//        }

        InsertSearch insertSearch = new InsertSearch();
        int index = insertSearch.insert_search(test, 0, test.length-1, 1);
        System.out.println(index);
    }

}

class InsertSearch {
    public int insert_search(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal > arr[right] || findVal < arr[left]) {
            return -1;
        }

        int mid = left + (right - left) * ((findVal - arr[left]) / (arr[right] - arr[left]));
        int midVal = arr[mid];

        if (midVal < findVal) {
            return insert_search(arr, mid + 1, right, findVal);
        } else if (midVal > findVal) {
            return insert_search(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
