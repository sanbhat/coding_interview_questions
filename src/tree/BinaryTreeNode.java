package tree;

public class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return  "["+ data + "]";
	}
	
}
