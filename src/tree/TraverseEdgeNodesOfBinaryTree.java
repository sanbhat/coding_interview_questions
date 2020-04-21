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

	private void traverseLeaves(BinaryTreeNode x) {
		if(x != null) {
			traverseLeaves(x.left);
			
			if(x.left == null && x.right == null) {
				System.out.println(x.data);
			}
			
			traverseLeaves(x.right);
		}
	}
	
	private void traverseLeftEdges(BinaryTreeNode x) {
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
	
	
	private void traverseRightEdges(BinaryTreeNode x) {
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
	
	public void traverseEdges(BinaryTreeNode root) {
		if(root != null) {
			System.out.println(root.data);
			
			traverseLeftEdges(root.left);
			traverseLeaves(root.left);
			//traverseLeaves(root.right);
			//traverseRightEdges(root.right);
		}
	}

	//                     20
	//					/     \
	//                8		  22
	//				/	\	 	\
	//			 4		 12		25
	//					/  \
	//				 10		14

	
	
	public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(12);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);
        root.right = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(25);
        new TraverseEdgeNodesOfBinaryTree().traverseEdges(root);
	}
}
