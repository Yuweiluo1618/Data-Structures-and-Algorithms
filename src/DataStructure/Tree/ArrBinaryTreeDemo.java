package DataStructure.Tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        arrBinaryTree.arrBinaryTreePreOrder(arr, 0);

    }
}

class ArrBinaryTree {
    public void arrBinaryTreePreOrder(int[] arr, int rootIndex) {
        if(arr == null || arr.length == 0){
            return;
        }

        System.out.println(arr[rootIndex]);

        if (2 * rootIndex + 1 < arr.length) {
            arrBinaryTreePreOrder(arr, 2 * rootIndex + 1);
        }

        if (2 * rootIndex + 2 < arr.length) {
            arrBinaryTreePreOrder(arr, 2 * rootIndex + 2);
        }

    }
}
