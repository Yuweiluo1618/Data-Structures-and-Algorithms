package DataStructure.Search;

import java.util.Arrays;

public class Fibonacci_Search {
    public static void main(String[] args) {
        FibonacciSearch fibonacciSearch = new FibonacciSearch();
        int[] test = {1, 3, 5, 7, 20, 30, 40};

        int index = fibonacciSearch.fibonacci_search(test,40 );

        System.out.println(index);

    }
}

class FibonacciSearch {
    int fibonacci_array_size = 20;

    public int[] getFibArr() {
        int[] fib = new int[fibonacci_array_size];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fibonacci_array_size; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

    public int fibonacci_search(int[] arr, int findVal) {
        int left = 0;
        int right = arr.length - 1;
        int[] fib = getFibArr();
        int fib_index = 0;

        while (arr.length > (fib[fib_index] - 1)) {
            fib_index++;
        }


        int[] temp = Arrays.copyOf(arr, fib[fib_index] - 1);
        for(int i = arr.length; i < temp.length; i++){
            temp[i] = arr[arr.length-1];
        }

        while (left <= right) {
            int mid = left + fib[fib_index - 1] - 1;
            if (findVal < arr[mid]) {
                right = mid - 1;
                fib_index--;
            } else if (findVal > arr[mid]) {
                left = mid + 1;
                fib_index -= 2;
            } else {
                if (mid <= arr.length - 1) {
                    return mid;
                } else {
                    return arr.length - 1;
                }
            }
        }

        return -1;
    }
}
