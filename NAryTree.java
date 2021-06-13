public class NAryTree {

	public class Node {
		int val;
		Node[] children;

		public Node(int val) {
			this.val = val;
		}
	}

	static Node maxRoot;
	static double maxval = Integer.MIN_VALUE;

	public static Node maximumAverageSubtree(Node root) {
		if (root == null)
			return null;
		dfs(root);
		return maxRoot;
	}

	public static double[] dfs(Node root) {
		if (root == null)
			return new double[] { 0, 0 };
		int curval = root.val;
		int nodes = 1;
		for (Node child : root.children) {
			double[] d = dfs(child);
			curval += d[0];
			nodes += d[1];
		}
		double average = curval / nodes;
		if (average > maxval && nodes > 1) {
			maxRoot = root;
			maxval = average;
		}
		return new double[] { curval, nodes };
	}
}
