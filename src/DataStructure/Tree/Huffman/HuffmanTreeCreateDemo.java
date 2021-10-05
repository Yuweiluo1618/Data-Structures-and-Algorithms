package DataStructure.Tree.Huffman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HuffmanTreeCreateDemo {
    public static void main(String[] args) {
        HuffmanTreeCreate huffmanTreeCreate = new HuffmanTreeCreate();
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffmanTreeCreate.huffmanTree(arr);
        huffmanTreeCreate.preOrder(root);

    }
}

class HuffmanTreeCreate {
    public Node huffmanTree(int[] arr) {
        ArrayList<Node> nodeArrayList = new ArrayList<Node>();
        for (int num : arr) {
            nodeArrayList.add(new Node(num));
        }

        while (nodeArrayList.size() > 1) {
            Collections.sort(nodeArrayList);
            Node leftNode = nodeArrayList.get(0);
            Node rightNode = nodeArrayList.get(1);

            Node parent = new Node(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;

            nodeArrayList.remove(leftNode);
            nodeArrayList.remove(rightNode);

            nodeArrayList.add(parent);
        }
        return nodeArrayList.get(0);
    }


    public void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}

class Node implements Comparable<Node> {
    public int val;
    public Node left;
    public Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.val - o.val;
    }
}
