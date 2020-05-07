package tree;

import tree.model.BinaryTreeNode;

public class BinaryTreeToSumTree {

    public BinaryTreeNode toSumTree(BinaryTreeNode root) {
        root.data = calcSum(root);
        return root;
    }

    private int calcSum(BinaryTreeNode n) {
        int sum = 0;
        if(n.left != null) {
            n.left.data = n.left.data + calcSum(n.left);
            sum += n.left.data;
        }
        if(n.right != null) {
            n.right.data = n.right.data + calcSum(n.right);
            sum += n.right.data;
        }
        if(n.left == null && n.right == null) {
            n.data = 0;
            sum = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(-2);
        root.right = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(8);
        root.left.right = new BinaryTreeNode(-4);

        root.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(5);
        BinaryTreeNode output = new BinaryTreeToSumTree().toSumTree(root);
        System.out.println(output);
    }
}
