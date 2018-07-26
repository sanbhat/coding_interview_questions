package tree;

/**
 * Traverse edge nodes of binary tree from root to left bottom, then left bottom to
 * right bottom and finally right bottom till root.
 * 
 * <a href='https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/'>https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/</a>
 * 
 * @author santhosh
 *
 */
public class TraverseEdgeNodesOfBinaryTree {

	private void traverseLeaves(Node x) {
		if(x != null) {
			traverseLeaves(x.left);
			
			if(x.left == null && x.right == null) {
				System.out.println(x.data);
			}
			
			traverseLeaves(x.right);
		}
	}
	
	private void traverseLeftEdges(Node x) {
		if(x != null) {
			if(x.left != null) {
				System.out.println(x.data);
				traverseLeftEdges(x.left);
			} else if(x.right != null) {
				System.out.println(x.data);
				traverseLeftEdges(x.right);
			}
		}
	}
	
	
	private void traverseRightEdges(Node x) {
		if(x != null) {
			if(x.right != null) {
				System.out.println(x.data);
				traverseRightEdges(x.right);
			} else if(x.left != null) {
				System.out.println(x.data);
				traverseRightEdges(x.left);
			}
		}
	}
	
	public void traverseEdges(Node root) {
		if(root != null) {
			System.out.println(root.data);
			
			traverseLeftEdges(root.left);
			traverseLeaves(root.left);
			traverseLeaves(root.right);
			traverseRightEdges(root.right);
		}
	}
	
	
	public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        new TraverseEdgeNodesOfBinaryTree().traverseEdges(root);
	}
}
