import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {
	class Node {
		int id, mask;

		public Node(int id, int mask) {
			this.id = id;
			this.mask = mask;
		}

		public String toString() {
			return id + " " + mask;
		}
	}

	public int shortestPathLength(int[][] graph) {
		Queue<Node> q = new LinkedList<Node>();
		HashSet<String> vis = new HashSet<String>();
		int fullMask = (1 << graph.length) - 1;
		for (int i = 0; i < graph.length; ++i) {
			Node n = new Node(i, 1 << i);
			q.add(n);
			vis.add(n.toString());
		}
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; ++i) {
				Node cur = q.poll();
				if (cur.mask == fullMask)
					return count;
				for (int next : graph[cur.id]) {
					Node n = new Node(next, cur.mask | (1 << next));
					if (!vis.contains(n.toString())) {
						vis.add(n.toString());
						q.add(n);
					}
				}
			}
			++count;
		}
		return count;
	}
}
