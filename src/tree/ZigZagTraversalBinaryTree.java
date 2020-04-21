package tree;

import java.util.Stack;

public class ZigZagTraversalBinaryTree {

	public void zigZagTraverse(BinaryTreeNode root) {
		Stack<BinaryTreeNode> current = new Stack<>();
		Stack<BinaryTreeNode> next = new Stack<>();
		boolean leftToRight = true;
		current.add(root);		
		
		while(!current.isEmpty()) {
			BinaryTreeNode c = current.pop();
			if(c != null) {
				System.out.println(c.data);
				if(leftToRight) {
					//when lefToRight is set, first add right and then left
					//to the stack
					next.push(c.right);
					next.push(c.left);
				} else {
					next.push(c.left);
					next.push(c.right);
				}

				if(current.isEmpty()) {
					Stack<BinaryTreeNode> temp = current;
					current = next;
					next = temp;
					leftToRight = !leftToRight;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(1);
	    root.left = new BinaryTreeNode(2);
	    root.right = new BinaryTreeNode(3);
	    root.left.left = new BinaryTreeNode(7);
	    root.left.right = new BinaryTreeNode(6);
	    root.right.left = new BinaryTreeNode(5);
	    root.right.right = new BinaryTreeNode(4);
	    new ZigZagTraversalBinaryTree().zigZagTraverse(root);
	}
}
