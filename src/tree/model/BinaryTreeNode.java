package tree.model;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode {

	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return  "[" + this.data + "]";
	}

}
