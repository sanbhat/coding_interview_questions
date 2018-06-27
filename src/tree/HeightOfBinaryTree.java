package tree;

public class HeightOfBinaryTree {

	static int height(Node root) {
        return height(root, 0);
    }

    static int height(Node x, int h) {
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
		Node root = new Node(3);
		root.left = new Node(2);
		root.left.left = new Node(1);
		
		root.right = new Node(5);
		root.right.left = new Node(4);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);
		
		System.out.println(height(root));
	}
}
