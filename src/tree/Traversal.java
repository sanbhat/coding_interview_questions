package tree;

import tree.model.BinaryTreeNode;

import java.util.Stack;

public class Traversal {

    public void preorderR(BinaryTreeNode x) {
        if(x != null) {
            System.out.println(x.data);
            if(x.left != null) {
                preorderR(x.left);
            }
            if(x.right != null) {
                preorderR(x.right);
            }
        }
    }

    public void postorderR(BinaryTreeNode x) {
        if(x != null) {
            if(x.left != null) {
                postorderR(x.left);
            }
            if(x.right != null) {
                postorderR(x.right);
            }
            System.out.println(x.data);
        }
    }

    public void inorderR(BinaryTreeNode x) {
        if(x != null) {
            if(x.left != null) {
                inorderR(x.left);
            }
            System.out.println(x.data);
            if(x.right != null) {
                inorderR(x.right);
            }
        }
    }

    public void inorderI(BinaryTreeNode x) {
        Stack<BinaryTreeNode> s = new Stack<>();
        while (x != null) {
            s.push(x);
            x = x.left;
        }

        while (!s.isEmpty()) {
            x = s.pop();
            System.out.println(x.data);

            if(x.right != null) {
                x = x.right;

                while(x != null) {
                    s.push(x);
                    x = x.left;
                }
            }
        }
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

        new Traversal().inorderR(root);
        new Traversal().inorderI(root);
    }
}
