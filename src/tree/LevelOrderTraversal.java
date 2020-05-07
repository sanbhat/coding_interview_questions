package tree;

import tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

public class LevelOrderTraversal {

    public void levelOrderTraversal(BinaryTreeNode x) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        levelOrder(q, x);
    }

    private void levelOrder(Queue<BinaryTreeNode> q, BinaryTreeNode x) {
        q.add(x);
        while(!q.isEmpty()) {
            BinaryTreeNode n = q.poll();
            System.out.print(n.data);
            if(n.left != null) {
                q.add(n.left);
            }
            if(n.right != null) {
                q.add(n.right);
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

        new LevelOrderTraversal().levelOrderTraversal(root);
    }
}
