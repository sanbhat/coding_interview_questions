package tree;

import java.util.Stack;

public class ZigZagTraversalBinaryTree {

	public void zigZagTraverse(Node root) {
		Stack<Node> current = new Stack<>();
		Stack<Node> next = new Stack<>();
		boolean leftToRight = true;
		current.add(root);		
		
		while(!current.isEmpty()) {
			Node c = current.pop();
			if(c != null) {
				System.out.println(c.data);
				if(leftToRight) {
					next.push(c.left);
					next.push(c.right);
				} else {
					next.push(c.right);
					next.push(c.left);
				}

				if(current.isEmpty()) {
					Stack<Node> temp = current;
					current = next;
					next = temp;
					leftToRight = !leftToRight;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(7);
	    root.left.right = new Node(6);
	    root.right.left = new Node(5);
	    root.right.right = new Node(4);
	    new ZigZagTraversalBinaryTree().zigZagTraverse(root);
	}
}
