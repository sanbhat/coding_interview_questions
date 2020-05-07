package tree;

import tree.model.BinaryTreeNode;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

    public void topView(BinaryTreeNode root) {
        Map<Integer, BinaryTreeNode> map = new TreeMap<>();
        topView(root, 0, map);

        for(Map.Entry<Integer, BinaryTreeNode> e : map.entrySet()) {
            System.out.println(e.getValue().data);
        }
    }

    private void topView(BinaryTreeNode node, int l, Map<Integer, BinaryTreeNode> map) {
        if(node == null) {
            return;
        }

        if(!map.containsKey(l)) {
            map.put(l, node);
        }

        topView(node.left, l-1, map);
        topView(node.right, l+1, map);
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

        new TopView().topView(root);
    }
}
