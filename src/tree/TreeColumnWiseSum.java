package tree;

import tree.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TreeColumnWiseSum {

	
	public Map<Integer, Integer> getColumnWiseSum(BinaryTreeNode root) {
		Map<BinaryTreeNode, Integer> columns = new HashMap<>();
		getColumns(columns, root, 0);
		
		//Convert the TreeNode vs. Column ID to Column ID vs. List<TreeNode>
		Map<Integer, List<BinaryTreeNode>> m = new HashMap<>();
		for(Entry<BinaryTreeNode, Integer> e : columns.entrySet()) {
			if(!m.containsKey(e.getValue())) {
				m.put(e.getValue(), new ArrayList<>());
			} 
			m.get(e.getValue()).add(e.getKey());
		}
		
		//for each column, calculate max sum
		Map<Integer, Integer> result = new HashMap<>();
		for(Entry<Integer, List<BinaryTreeNode>> e : m.entrySet()) {
			int value = e.getValue().stream().mapToInt(t -> t.data).sum();
			result.put(e.getKey(), value);
		}
		
		return result;
	}

	/**
	 * For each tree node, assign a column identifier. Let the root column be 0.
	 * For the left tree, decrement the id by 1 and for right tree, increment the 
	 * id by 1.
	 * @param columns
	 * @param node
	 * @param c
	 */
	private void getColumns(Map<BinaryTreeNode, Integer> columns, BinaryTreeNode node, int c) {
		columns.put(node, c);
		if(node.left != null) {
			getColumns(columns, node.left, c--);
		}
		if(node.right != null) {
			getColumns(columns, node.right, c++);
		}
	}
}
