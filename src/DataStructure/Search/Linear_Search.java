package DataStructure.Search;

public class Linear_Search {
    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int[] test = {-1, 2, 3, 4, 5};
        int index = linearSearch.linear_search(test, 8);
        System.out.println(index);
    }
}

class LinearSearch {
    public int linear_search(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == k){
                return i;
            }
        }

        return -1;
    }
}
