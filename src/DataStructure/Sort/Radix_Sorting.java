package DataStructure.Sort;

import java.util.Arrays;

public class Radix_Sorting {
    public static void main(String[] args) {
        int[] test = {3,2,7,6,8,10,500,5,1};
        RadixSort radixSort = new RadixSort();
        radixSort.radix_sort(test);
        System.out.println(Arrays.toString(test));

    }
}

class RadixSort {
    public void radix_sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        String maxStr = max + "";
        int radix_count = maxStr.length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketCounter = new int[10];
        int arrCounter = 0;

        for (int i = 0; i < radix_count; i++) {

            for (int j = 0; j < arr.length; j++) {
                int bucket_index = (int) (arr[j] / Math.pow(10, i)) % 10;
                bucket[bucket_index][bucketCounter[bucket_index]] = arr[j];
                bucketCounter[bucket_index]++;
            }

            for (int k = 0; k < bucket.length; k++) {
                if(bucketCounter[k] != 0){
                    for(int l = 0; l < bucketCounter[k]; l++){
                        arr[arrCounter] = bucket[k][l];
                        arrCounter++;
                    }
                    bucketCounter[k] = 0;
                }
            }
            arrCounter = 0;

        }

    }
}
