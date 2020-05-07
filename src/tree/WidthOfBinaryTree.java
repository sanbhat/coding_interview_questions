package tree;

import tree.model.BinaryTreeNode;

import java.util.*;

public class WidthOfBinaryTree {

    public static int width(BinaryTreeNode root) {
        //To be understood and implemented
        return 0;
    }

    //              3
    //           2       5
    //         1       4    6
    //                          7

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(1);

        root.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(6);
        root.right.right.right = new BinaryTreeNode(7);

        System.out.println(width(root));
    }
}
