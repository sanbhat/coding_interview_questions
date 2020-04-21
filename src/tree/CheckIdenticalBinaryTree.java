package tree;

public class CheckIdenticalBinaryTree {

    public static boolean isIdentical(BinaryTreeNode x, BinaryTreeNode y) {
        if(x == null && y == null) {
            return true;
        }

       return (x != null && y != null) && (x.data == y.data)
               && (isIdentical(x.left, y.left))
               && (isIdentical(x.right, y.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode x = new BinaryTreeNode(10);
        x.left = new BinaryTreeNode(8);
        x.right = new BinaryTreeNode(12);

        BinaryTreeNode y = new BinaryTreeNode(10);
        y.left = new BinaryTreeNode(8);
        y.right = new BinaryTreeNode(12);

        System.out.println(isIdentical(x, y));
    }
}
