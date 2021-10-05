package DataStructure.Tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(14);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.threadedBinaryPre(node1);
        threadedBinaryTree.printPreOrder(node1);


    }

}

class ThreadedBinaryTree {
    public TreeNode root;
    public TreeNode pre;

    public void threadedBinaryIn(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        threadedBinaryIn(treeNode.left);


        if (treeNode.left == null) {
            treeNode.left = pre;
            treeNode.leftType = 1;
        }

        if (pre != null && pre.right == null) {
            pre.right = treeNode;
            pre.rightType = 1;
        }

        pre = treeNode;


        threadedBinaryIn(treeNode.right);


    }

    public void threadedBinaryPre(TreeNode treeNode) {

        if (treeNode.left == null) {
            treeNode.left = pre;
            treeNode.leftType = 1;

        }

        if (pre != null && pre.right == null) {
            pre.right = treeNode;
            pre.rightType = 1;
        }

        pre = treeNode;

        if (treeNode.left != null && treeNode.leftType != 1) {
            threadedBinaryPre(treeNode.left);
        }
        if (treeNode.right != null && treeNode.rightType != 1) {
            threadedBinaryPre(treeNode.right);
        }
    }

    public void threadedBinaryPost(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        threadedBinaryPost(treeNode.left);
        threadedBinaryPost(treeNode.right);

        if(treeNode.left == null){
            treeNode.left = pre;
            treeNode.leftType = 1;
        }

        if(pre != null && pre.right == null){
            pre.right = treeNode;
            pre.rightType = 1;
        }

        pre =treeNode;
    }

    public void printInOrder(TreeNode treeNode){
        while (treeNode != null){
            while (treeNode.leftType == 0){
                treeNode = treeNode.left;
            }
            System.out.println(treeNode);

            while (treeNode.rightType == 1){
                treeNode = treeNode.right;
                System.out.println(treeNode);
            }

            treeNode = treeNode.right;
        }
    }

    public void printPreOrder(TreeNode treeNode){
        while (true){
            System.out.println(treeNode);
            while (treeNode.rightType == 1){
                treeNode = treeNode.right;
                System.out.println(treeNode);
            }

            if(treeNode.right == null){
                break;
            }

            treeNode = treeNode.left;

        }
    }

}

class TreeNode {
    public int no;
    public TreeNode left;
    public TreeNode right;
    public int leftType;
    public int rightType;


    public TreeNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }
}
