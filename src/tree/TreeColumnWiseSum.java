package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TreeColumnWiseSum {

	class TreeNode {
		int value;
		
		TreeNode left;
		
		TreeNode right;
	}
	
	public Map<Integer, Integer> getColumnWiseSum(TreeNode root) {
		Map<TreeNode, Integer> columns = new HashMap<>();
		getColumns(columns, root, 0);
		
		Map<Integer, List<TreeNode>> m = new HashMap<>();
		for(Entry<TreeNode, Integer> e : columns.entrySet()) {
			if(!m.containsKey(e.getValue())) {
				m.put(e.getValue(), new ArrayList<>());
			} 
			m.get(e.getValue()).add(e.getKey());
		}
		
		Map<Integer, Integer> result = new HashMap<>();
		for(Entry<Integer, List<TreeNode>> e : m.entrySet()) {
			int value = e.getValue().stream().mapToInt(t -> t.value).sum();
			result.put(e.getKey(), value);
		}
		
		return result;
	}

	private void getColumns(Map<TreeNode, Integer> columns, TreeNode node, int c) {
		columns.put(node, c);
		if(node.left != null) {
			getColumns(columns, node.left, c--);
		}
		if(node.right != null) {
			getColumns(columns, node.right, c++);
		}
	}
}
