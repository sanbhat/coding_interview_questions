package tree;

import tree.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public void reverseLevelOrder(BinaryTreeNode node) {
        Stack<Integer> s = new Stack<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        reverseLevelOrder(node, q, s);
        while(!s.isEmpty()) {
            System.out.print(s.pop());
        }
    }

    private void reverseLevelOrder(BinaryTreeNode node, Queue<BinaryTreeNode> q, Stack<Integer> s) {
        if(node != null)
            q.add(node);
        while(!q.isEmpty()) {
            BinaryTreeNode n = q.poll();
            s.push(n.data);
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

        new ReverseLevelOrderTraversal().reverseLevelOrder(root);
    }
}
