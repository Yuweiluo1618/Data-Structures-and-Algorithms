package DataStructure.Array;

import java.util.Arrays;

public class DS_Sparse_Array {

    public static int[][] toSparseArray(int[][] a){
        int row = a.length;
        int col = a[0].length;
        int sum = 0;
        int count = 1;

        for (int i = 0; i < row; i++ ){
            for (int j = 0; j < col; j++){
                if(a[i][j] != 0){
                    sum++;
                }
            }
        }

        int[][] sparse_array = new int[sum+1][3];
        sparse_array[0][0] = row;
        sparse_array[0][1] = col;
        sparse_array[0][2] = sum;

        for (int i = 0; i < row; i++ ){
            for (int j = 0; j < col; j++){
                if(a[i][j] != 0){
                    sparse_array[count][0] = i;
                    sparse_array[count][1] = j;
                    sparse_array[count][2] = a[i][j];
                    count++;
                }
            }
        }

        return  sparse_array;
    }

    public static int[][] toOriArray(int[][] a){
        int row = a[0][0];
        int col = a[0][1];
        int [][] ori_array = new int[row][col];
        for (int i = 1; i < a.length; i++){
           ori_array[a[i][0]][a[i][1]] = a[i][2];
        }

        return ori_array;
    }

    public static void main(String[] args) {
        int[][] test = new int[11][11];
        test[1][2] = 1;
        test[2][3] = 2;
//        System.out.println(Arrays.deepToString(toSparseArray(test)));
        System.out.println(Arrays.deepToString(toOriArray(toSparseArray(test))));
    }
}
