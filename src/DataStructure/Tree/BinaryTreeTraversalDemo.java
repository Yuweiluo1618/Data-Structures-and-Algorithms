package DataStructure.Tree;

public class BinaryTreeTraversalDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "song jiang");
        HeroNode node2 = new HeroNode(2, "wuyong");
        HeroNode node3 = new HeroNode(3, "lujunyi");
        HeroNode node4 = new HeroNode(4, "linchong");
        HeroNode node5 = new HeroNode(5, "guansheng");

        root.left = node2;
        root.right = node3;
        node3.left = node5;
        node3.right = node4;

        binaryTree.setRoot(root);

//        binaryTree.preOrder();
//        System.out.println("-----------------");
//        binaryTree.inOrder();
//        System.out.println("-----------------");
//        binaryTree.postOrder();
//
//
//        System.out.println("-----------------");
//        System.out.println(binaryTree.preOrderSearch(5));


    }
}

class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("root not exist");
        }
    }

    public void inOrder() {
        if (root != null) {
            root.inOrder();
        } else {
            System.out.println("root not exist");
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("root not exist");
        }
    }

    public HeroNode preOrderSearch(int id) {
        if (root != null) {
            return root.PreOrderSearch(id);
        } else {
            return null;
        }
    }

    public HeroNode inOrderSearch(int id) {
        if (root != null) {
            return root.inOrderSearch(id);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int id) {
        if (root != null) {
            return root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    public void delNode(int no) {
        if (root == null) {
            System.out.println("The root is null");
            return;
        }

        if (root.no == no) {
            root = null;
        } else {
            root.delNode(no);
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //Pre-Order Traversal
    public void preOrder() {

        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //In-Order Traversal
    public void inOrder() {

        if (this.left != null) {
            this.left.inOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.inOrder();
        }
    }

    //Post-Order Traversal
    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }

    //Pre-Order Search
    public HeroNode PreOrderSearch(int id) {
        if (this.no == id) {
            return this;
        }

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.PreOrderSearch(id);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.right != null) {
            resNode = this.right.PreOrderSearch(id);
        }

        return resNode;
    }

    //In-Order Search
    public HeroNode inOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.inOrderSearch(id);
        }

        if (resNode != null) {
            return resNode;
        }

        if (this.no == id) {
            return this;
        }

        if (this.right != null) {
            resNode = inOrderSearch(id);
        }

        return resNode;
    }

    //Post-order search
    public HeroNode postOrderSearch(int id) {
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(id);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == id) {
            return this;
        }
        return resNode;
    }

    //delete Node(simple)
    public void delNode(int no) {

        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }

        if (this.left != null) {
            this.left.delNode(no);
        }

        if (this.right != null) {
            this.right.delNode(no);
        }

    }

}
