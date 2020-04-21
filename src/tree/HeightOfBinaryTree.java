package tree;

public class HeightOfBinaryTree {

	static int height(BinaryTreeNode root) {
        return height(root, 0);
    }

    static int height(BinaryTreeNode x, int h) {
        int r = h;
        if(x != null) {
            if(x.left != null) {
                int lh = height(x.left, h+1);
                if(lh > h) {
                    r = lh;
                }
            }
            if(x.right != null) {
                int rh = height(x.right, h+1);
                if(rh > h) {
                    r = rh;
                }
            }
        }
        return r;
    }
	
	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode(3);
		root.left = new BinaryTreeNode(2);
		root.left.left = new BinaryTreeNode(1);
		
		root.right = new BinaryTreeNode(5);
		root.right.left = new BinaryTreeNode(4);
		root.right.right = new BinaryTreeNode(6);
		root.right.right.right = new BinaryTreeNode(7);
		
		System.out.println(height(root));
	}
}
