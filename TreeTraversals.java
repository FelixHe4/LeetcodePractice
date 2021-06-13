import java.util.List;

public class TreeTraversals {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public void preOrder(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		l.add(root.val);
		preOrder(root.left, l);
		preOrder(root.right, l);
	}

	public void postOrder(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		postOrder(root.left, l);
		postOrder(root.right, l);
		l.add(root.val);
	}

	public void inOrder(TreeNode root, List<Integer> l) {
		if (root == null)
			return;
		inOrder(root.left, l);
		l.add(root.val);
		inOrder(root.right, l);
	}
}
