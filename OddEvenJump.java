import java.util.TreeMap;

public class OddEvenJump {

	public int oddEvenJumps(int[] arr) {
		int n = arr.length;
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		boolean[][] dp = new boolean[n][2];
		// 0 is even move, 1 is odd move;
		dp[n - 1][0] = true;
		dp[n - 1][1] = true;
		tm.put(arr[n - 1], n - 1);
		int count = 1;
		for (int i = n - 2; i >= 0; --i) {
			Integer top = tm.ceilingKey(arr[i]);
			if (top != null) {
				dp[i][0] = dp[tm.get(top)][1];
			}
			Integer bottom = tm.floorKey(arr[i]);
			if (bottom != null) {
				dp[i][1] = dp[tm.get(bottom)][0];
			}
			tm.put(arr[i], i);
			count += dp[i][0] ? 1 : 0;
		}
		return count;
	}
}
